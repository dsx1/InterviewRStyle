package rstyleinterview4.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import rstyleinterview4.model.Arrest;
import rstyleinterview4.model.Client;
import rstyleinterview4.model.Message;



@Component
public class MessageServiceImpl implements MessageService{
    private final JdbcTemplate jdbcTemplate;
    private final ClientService clientService;
    private final ArrestService arrestService;

    public MessageServiceImpl(JdbcTemplate jdbcTemplate, ClientService clientService, ArrestService arrestService) {
        this.jdbcTemplate = jdbcTemplate;
        this.clientService = clientService;
        this.arrestService = arrestService;
    }

    @Override
    public String create(Message message) {
        StringBuilder resultText=new StringBuilder();
        String messageResult = checkMessage(message);
        if (messageResult.equals("")){
            switch (message.getOperation()){
                case (1):
                    int arrestId=arrestService.create(new Arrest(message.getOrganCode(), message.getArrestDocDate(),message.getArrestDocNumber(), message.getPurpose(), message.getAmount(), message.getArrestRefDocNumber(), message.getOperation()));
                    if (arrestId!=0){

                        if (clientService.read(message.getLastName(),message.getFirstName(), message.getDocumentType(), message.getDocumentNumber())!=null){
                            jdbcTemplate.update("UPDATE client set arrests=array_append(arrests,?)", arrestId);
                            resultText.append("ArrestId: " + arrestId);
                            resultText.append(" ResultCode: " + 0);
                        }
                        else {
                            Client client = new Client(message.getLastName(), message.getFirstName(), message.getDocumentType(), message.getDocumentNumber(),message.getBirthDate(), message.getBirthPlace(), new Integer[]{arrestId});
                            clientService.create(client);
                            resultText.append("ArrestId: " + arrestId);
                            resultText.append(" ResultCode: " + 0);
                        }
                    }
                    if (jdbcTemplate.update("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",message.getRequestId(), message.getLastName(), message.getFirstName(), message.getDocumentType(), message.getDocumentNumber(), message.getIssueDate(), message.getOrganCode(), message.getArrestDocDate(), message.getArrestDocNumber(), message.getPurpose(), message.getAmount(), message.getArrestRefDocNumber(), message.getOperation())!=0)
                    {
                        resultText.append("ArrestId: " + arrestId);
                        resultText.append(" ResultCode: "+ 0);
                    }
                    break;
                case (2):
                    Arrest arrestRefDoc = arrestService.read(message.getArrestRefDocNumber());
                    if(arrestRefDoc!=null){
                        if (arrestService.update(arrestRefDoc.getId(), message.getPurpose(), message.getAmount(), message.getOperation())!=0){
                            resultText.append("ArrestId: " + arrestRefDoc.getId());
                            resultText.append(" ResultCode: " + 0);
                        }
                    }
                case (3):
                    arrestRefDoc = arrestService.read(message.getArrestRefDocNumber());
                    if(arrestRefDoc!=null && message.getAmount()==0L){
                        if (arrestService.update(arrestRefDoc.getId(), message.getPurpose(), message.getAmount(), message.getOperation())!=0){
                            resultText.append("ArrestId: " + arrestRefDoc.getId());
                            resultText.append(" ResultCode: " + 0);
                        }
                    }
                default:
                    resultText.append("ResultCode: " + 5);
                    resultText.append("ResultText: " + messageResult);
                    return resultText.toString();
            }


        }
        return resultText.toString();

    }



    @Override
    public String checkMessage(Message message){
        StringBuilder sb = new StringBuilder();
        if (message.getLastName().length()<100 && !message.getLastName().isEmpty()){
            if (message.getFirstName().length()<100 && !message.getFirstName().isEmpty()){
                if (message.getDocumentType() == 1 || message.getDocumentType()==2){

                        if (message.getOrganCode() == 17 || message.getOrganCode()==39){
                            if (message.getArrestDocNumber().length()<30 && !message.getArrestDocNumber().isEmpty()){
                                if(message.getPurpose().length()<1000 && !message.getPurpose().isEmpty()){
                                    return "";
                                }
                            }
                            else{
                                sb.append("Ошибка при вводе номера документа ареста;");
                            }
                        }
                        else {
                            sb.append("Ошибка при вводе кода гос.органа;");
                        }


                }
                else {
                    sb.append("Ошибка при вводе типа ДУЛ;");
                }
            }
            else {
                sb.append("Ошибка при вводе имени;");
            }
        }
        else {
            sb.append("Ошибка при вводе фамилии;");
        }
        return sb.toString();
    }


}

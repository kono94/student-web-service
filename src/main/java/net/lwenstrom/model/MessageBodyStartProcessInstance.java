package net.lwenstrom.model;

public class MessageBodyStartProcessInstance {
    Variables variables;
    String businessKey;

    public MessageBodyStartProcessInstance(int studentID){
        variables = new Variables();
        variables.studentID = new Variable();
        variables.studentID.value = Integer.toString(studentID);
        variables.studentID.type = "long";
        businessKey = Integer.toString(studentID);
    }
    class Variables{
        Variable studentID;
    }

    class Variable{
        String value;
        String type;
    }
}

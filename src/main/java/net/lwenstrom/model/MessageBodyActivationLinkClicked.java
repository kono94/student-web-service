package net.lwenstrom.model;

public class MessageBodyActivationLinkClicked {
    String messageName;
    boolean all = false;
    CorrelationKeys correlationKeys;

    public MessageBodyActivationLinkClicked(String uuid){
        messageName = "activationLinkClickedMessage";
        correlationKeys = new CorrelationKeys();
        correlationKeys.activationLink = new ActivationLink();
        correlationKeys.activationLink.value = uuid;
        correlationKeys.activationLink.type = "String";
    }

    class CorrelationKeys{
        ActivationLink activationLink;
    }

    class ActivationLink{
        String value;
        String type;
    }
}

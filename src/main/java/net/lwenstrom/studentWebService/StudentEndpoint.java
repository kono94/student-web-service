package net.lwenstrom.studentWebService;


import net.lwenstrom.ws.students.GetStudentRequest;
import net.lwenstrom.ws.students.GetStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {
    private static final String NAMESPACE_URI = "lwenstrom.net/ws/students";

    private StudentRepository studentRepository;

    @Autowired
    public StudentEndpoint(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
        System.out.println("Request");
        System.out.println(request.getStudentID());
        GetStudentResponse response = new GetStudentResponse();
        response.setStudent(studentRepository.findStudent(request.getStudentID()));
        System.out.println(studentRepository.findStudent(request.getStudentID()));
        return response;
    }
}

package protocol_buffer_test;

import java.util.List;
import com.google.protobuf.InvalidProtocolBufferException;
import com.protobuftest.protobuf.PersonProbuf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Runtime;
import java.io.IOException;
public class ActivityMain { 
 
 
  public   static   void   main(String[]   args)   {  
   
   serializable();
   
 } 
     
 public static void serializable() {
   // TODO Auto-generated method stub
   //序列化

	
   PersonProbuf.Person.Builder builder = PersonProbuf.Person.newBuilder();
   builder.setEmail("kkk＠email.com");
   builder.setId(1);
   builder.setName("TestName");
   builder.addPhone(PersonProbuf.Person.PhoneNumber.newBuilder().setNumber("131111111").setType(PersonProbuf.Person.PhoneType.MOBILE));
   builder.addPhone(PersonProbuf.Person.PhoneNumber.newBuilder().setNumber("011111").setType(PersonProbuf.Person.PhoneType.HOME)); 
   PersonProbuf.Person person = builder.build();
   byte[] buf = person.toByteArray();
   String buffer = person.toString();
   System.out.println(buffer);
        //反序列化
   try {

       PersonProbuf.Person person2 = PersonProbuf.Person.parseFrom(buf);
       System.out.println(person2.getId()+","+person2.getName() + "， " + person2.getEmail());
       List<PersonProbuf.Person.PhoneNumber> lstPhones = person2.getPhoneList();
       for(PersonProbuf.Person.PhoneNumber phoneNumber : lstPhones) {
       System.out.println(phoneNumber.getNumber());
   }
   } catch (InvalidProtocolBufferException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   }
   System.out.println("Finish"); 
 }
}
SpringMongoDB
=============

This project saves phone numbers with username and surname and also shows phone list on the same page. User can delete or update fields from the same page.

Technologies:
Maven
Spring
MongoDB
Tomcat
jsp
JQuery

  There are 4(Username,Surname,Phone number and captcha) fields which are all must fill from user. Without filling captcha,save button does not activate. Without filling other fields, validations will warn to user. Phone input place has a phonemask that user can't write that area any characters.
  
  Model class has 4 features;
    -id
    -userName
    -surName
    -phoneNumber
    
  Service class has 5 methods;
    -addUser
    -listUser
    -deleteUser
    -updateUser
    -getUser
    
  



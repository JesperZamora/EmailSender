# EmailSender
This is an custom email service using the google api and java spring JavaMailSender Api.
I'm using Spring Boot an for the dependencies:

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

<br>

This project can be used for a website that has a form for customers to reach out to a company.
When a customer fills out the form their message will be sendt your email and an auto-reply mail will be sent to the customer.
There are two custom classes that contains the html/css, CustomerMessage and AutoReply.
The CustomerMessage class is the form that the company will get with the customer information, AutoReply class holds auto-message.

You will need to make an "App password" on your google account. 
 - Login to your google account go to "Manage Your Account" (click on your picture in the left corner).
 - Search for "App password" and create a password.
 - Place the password as an Environment Variable in your (see application properties file) and do the same for your gmail (xxx@gmail.com)


#### Remember! An App password will be rewoked by google if you change your password to your account.

<br>

Postman was used to test the endpoints. There are two endpoints, the one pictured below is the one you should use because it uses the MimeMessage class that can be used to send multiple attachements, files, images, html/css content etc. The other endpoint goes to the sendEmail() metode that uses the SimpleMessage class which is just a walmart version.

<br>

```
http://localhost:8080/send-mime
```

<br>

```json
{
    "to": "yourmail@gmail.com",
    "reply": "[customersmails]@xxx.com",
    "subject": "Test nr.1",
    "number": "12345678",
    "message": "This is a test message...."
}
```


<br>

This is not a finished project, but it gives an overall picture on how to use it at implement it, kinda.. You will see comments in the project, where you should handle and exception with try-catch instead of throwing it and maybe make a custom class. You could also make some sort of validation of the EmailMesssage object recieved, just to validate the email.

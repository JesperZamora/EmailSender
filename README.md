# EmailSender
This is an custom email service using the google api and java spring JavaMailSender Api

This project can be used for a website that has a form for customers to reach out to a company.
When a customer fills out the form their message will be sendt your email and an auto-reply mail will be sent to the customer.
There are two custom classes that contains the html/css, CustomerMessage and AutoReply.
The CustomerMessage class is the form that the company will get with the customer information, AutoReply class holds auto-message.

You will need to make an "App password" on your google account. 
 - Login to your google account go to "Manage Your Account" (click on your picture in the left corner).
 - Search for "App password" and create a password.
 - Place it as an Environment Variable
 - Do the same for your gmail (xxx@gmail.com)

Remember! A App password will be rewoked by google if you change your password to your account.

Postman was used to test the endpoints.
```json
{
    "to": "yourmail@gmail.com",
    "reply": "[customersmails]@xxx.com",
    "subject": "Test nr.1",
    "number": "12345678",
    "message": "This is a test message...."
}
```


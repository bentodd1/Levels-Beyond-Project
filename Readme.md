#Levels Beyond Coding Assignment

This project consists of 2 parts.  

The back end part is a server side note application.  The application uses a restful web service and takes and returns JSON Note objects.  The application uses spring and apache cxf.

The font end part is web page that uses the GitHub api to display all issues with angular within the last 7 days.

##Back End

###Set Up

Note:  This was tested using apache tomcat 8.5
To run open up eclipse and go to File->Import->Maven->Existing Maven
Next find the folder Back End/api. Click next and finish the project.

Right click the project and go to run as- > Maven Clean
Right click the project and go to run as -> Maven Install
Right click the project and go to run as -> Run On Server and select your server.
Note:  This was tested using apache tomcat 8.5.

To view your wadl go to host:port/api/notes?_wadl

###Examples:

Create a new note

curl -i -H "Content-Type: application/json" -X POST -d '{"body" : "Pick up milk!"}' 127.0.0.1:8080/api/notes

Get a specific note

curl -i -H "Content-Type: application/json" -X GET 127.0.0.1:8080/api/notes/1

Get List of all notes

curl -i -H "Content-Type: application/json" -X GET 127.0.0.1:8080/api/notes

Get notes with query 

curl -i -H "Content-Type: application/json" -X GET 127.0.0.1:8080/api/notes?query=milk

###Extra
The BackEnd uses a map to perform operations.  This is for easy configuration as no database needs to be configured.    All data will be lost when the server restarts.

##Front End

Navigate to Front End/Index.html
Double Click to launch in Chrome or Firefox.
Displays issues from the last 7 days(a maximum of 30 is returned).


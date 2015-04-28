# BookInventoryMgmt

Software Required:

- Eclipse IDE (latest)
- Apache Tomcat 7.0
- Mysql Server and Workbench
- Chrome Postman to hit request for output


Description of the project:

* Book Inventory Management gives an idea of how basic Restful web service works
* Here, we are going to hit few http GET and POST request to Add, Get, Delete book from our database

How to proceed:

* Download the book-inventory-management zip
* Unzip the folder, and run the DB.sql in MySql
* Navigate till BookInventoryManagement folder and import ScanBuy project in your eclipse
* Configure the project and run it on Tomcat server local host

How to execute:

* Once you execute the project, go to Chrome Postman(preferred) or your eclipse browser
* Hit the following http commands in Chrome postman with URL request parameters:

1. Add Book
Http Request format: 
http://localhost:8080/ScanBuy/addBook? barcode={id} & name={name} & author={autor} & pageNum={page num} & read={YES/NO}

Result we will get in JSON format:

Success:
{
"respMessage": "Successfully Added",
"statusMessage": "SUCCESS",
"errCode": null
}

Duplicate Entry:
{
"respMessage": "Duplicate entry '232' for key 'PRIMARY'",
"statusMessage": "UNSUCCESSFUL",
"errCode": "1062"
}

If Barcode length > 12
{
"respMessage": "Barcode greater than 12 digits",
"statusMessage": "UNSUCCESSFUL",
"errCode": null
}

2. Get Book Info
Http Request format:
http://localhost:8080/ScanBuy/getBookInfo?barcode={barcode}

Result will be in JSON format:
Success:

{
-"book": {
    "barcode": 120,
    "nameOfBook": "Harry Potter",
    "authorName": "J.K Rowlings",
    "numOfPages": 234,
    "read": "yes"
},

"statusMessage": "SUCCESS",
"respMessage": null

}

No Entry for given barcode:

{
"book": null,
"statusMessage": "UNSUCCESS",
"respMessage": "Record with barcode:1209 don't exists"
}

3. Delete Book 
Http Request format:
http://localhost:8080/ScanBuy/deleteBook?barcode={barcode}

Result will be in JSON format:
Success:

{
"statusMessage": "SUCCESS",
"respMessage": null
}

No Entry for given barcode:

{
"statusMessage": "UNSUCCESS",
"respMessage": "Record with barcode:1209 don't exists"
}

How to use Chrome Postman:
* Copy any URL like : http://localhost:8080/ScanBuy/addBook
* Add all the required Request Parameters
* You can choose between GET or POST methods
* Press Send and will see the output


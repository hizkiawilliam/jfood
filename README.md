# jfood v.1.2

This is an Android application project for Object Oriented Programming course, Computer Engineering, Universitas Indonesia.
To use this app, jfood-android and jfood projects need to be used. jfood-android is Android Studio project while jfood is Java project developed in IntelliJ. The purpose of jfood project is to serve as backend program and database handler.

Tools used in the project:
- Java Programming Language
- Springboot Framework
- PostgreSQL for database
- Android Studio
- IntelliJ

Version Changelogs:
  - v1.0  : 
    - Database for Customer is synced with Postgres. Other objects is yet to be sycned
    - Fixed cart system for ordering foods
    - Fixed Promo Code searches
    - Multiple foods in cart can be ordered
    - Various error handling for Customer Register
    - Total Price has been adjusted not by individual foods
  - v1.1  : 
    - All databases are using Postgres
    - Various fix for exceptions
  - v1.2  : 
    - Database sync fix
    - Add navigation bar to jfood-android
    - Fetching request for ongoing invoice fixed
    - UI improvements
    - Fix bugs in found in v1.1
    - Error handling for cart system
    
 Knownbugs  :
  - v1.1  : 
    - Wrong toast when ordering if invoice Ongoing exist (BuatPesananActivity.java)
 

BBC Test
============

This application is a solution to a BBC test for those applying to the position of **Software Engineer**. The test consist on resolving a generic problem following the following guideline:

> Roman Numeral Converter
> ---------------------
>
> Write an application that converts a number into a Roman Numeral.
> 
> The application should preferably expose a Web Service (e.g. using Spring MVC), but could also be a Command Line application.
> 
> For example, see the following sample inputs and outputs:
>
> - 1 = “I”
> - 5 = “V”
> - 10 = “X”
> - 20 = “XX”
> - 3999 = “MMMCMXCIX”
> 
> 
> **Caveat**: Only support numbers between 1 and 3999

Run Application
----------------
To run the application follow the next steps:
 
 - Open a terminal and change to the project root directory
 - Run the command `sh ./gradlew installApp`
 - Run the command `sh ./build/install/romanNumerals/bin/romanNumerals`
 - Now perform a get call to the endpoint `http://localhost:8080/convertToRomanNumeral/{number}`, for instance:
 
   `curl http://localhost:8080/convertToRomanNumeral/3999`

*For more information please contact [Ricardo Villanueva](villanueva.ricardo@gmail.com)*
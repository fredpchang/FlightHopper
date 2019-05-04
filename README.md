# FlightHopper - README


# Setup

## FlightScraper.java (Setup JSON Jar)
1. Right click project folder --> Build Path --> Configure Build Path --> Libraries --> Add External JARs
2. Navigate to where JAR is stored (/lib/json-simple-1.1.1.jar)

## FlightScraper.java (Setup Python3 Environment)
1. Download Canopy (*https://store.enthought.com/downloads/*)
2. Locate your Python path. These are known paths for Windows/Mac, however, the exact path is not guaranteed and the user will need to locate where their Canopy Python installation is relative to their machine.

 Mac: */Users/yourNameHere/Library/Enthought/Canopy/edm/envs/User/bin/python3*

 Windows: *C:\\Users\\yourNameHere\\AppData\\Local\\Enthought\\Canopy\\edm\\envs\\User\\python.exe*

 How to find python path in general: create a python file in canopy. Write:

 `import sys`

 `print(sys.executable)`

 Run the file and the output of this file is your python path in canopy

3. Replace variable pythonpath with : *"yourPath"* . This command is located in scraperPyHelper() method.


--------------------------------------------------------------
# External APIs, Libraries, Scripts, Datasets

## Expedia Python Scraper
Source: https://gist.github.com/scrapehero/bc34513e2ea72dc0890ad47fbd8a1a4f

## SimpleJSON
Source: https://github.com/simplejson/simplejson

## Historical Flight Dataset
Source: https://www.kaggle.com/usdot/flight-delays#flights.csv


--------------------------------------------------------------

# Regarding Test Code Coverage
Due to the nature of our program pulling real-time ticket information from Expedia, it is virtually impossible to test for same results (unless we run the test right after writing it). We have included recordings of our test passing in our submission.

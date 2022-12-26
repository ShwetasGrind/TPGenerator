Project Title:
	TestPlanCreator

Description:

	Since there are a lot of pipelines with bi-weekly and innovation releases, we must create test plans and add test cases/test suites to it. This may be time consuming and a bummer for anybody who's creating the same, since there are other tasks lined up with tight deadlines too.
 
	TestPlanCreator.exe is an executable file to streamline the process of generating test plans in RQM and adding test cases to it, which is created in an optimized way, generating reports to track test plan details in a timely manner. With influx suggestions and ideas, it is now enhanced to add Test Environments,Test Suites and to create TCER for Test Suites and Test Cases respectively. 

Getting Started:
	-Dependencies:
		1.ChromeDriver (compatible with google chrome browser)
		2.Java JDK 1.8 [Minimum]
		3.Test Cases Excel Sheet (xlsx format)
		4.Solution Data Excel Sheet (xlsx format)
		5.Generic.Properties file
		6.WarningMsg.exe
		
	-Installion/Configuration:
		1.Create a folder in following path "C:\RQMTestPlanCreator". Add Generic.properties,Solutiondata.xlsx file.
		2.Create Subfolder "C:\RQMTestPlanCreator\Dependencies" and add ChromeDriver and WarningMsg.exe files to it.
		3.Modify Generic.properties file such that user must pass the following data. The data would be Case Sensitive.
			->ExcelPath : path where you have placed the excel with test case details
				eg: ExcelPath=C:\\2018.02.04\\erm_660885.xlsx
			->SolMnemonics : From which sheet of your excel the data to be pulled
				eg: SheetName=Sheet1 or "All" for all sheets in Solutiondata.xlsx
			->TestPlanName : Test plan name to be created in RQM
				eg: TestPlanName=R-2018.03.14
			->currentRelease : The current release data to provide in Release Text box
				eg: currentRelease=2018.03.14
			->UserName : User name to login to RQM
				eg: UserName=AB******
			->Password : Password to login to RQM
				eg: Password=*********
			->ExcelSheetTCColNum :  Enter the column number where test case name are saved in excel (Note: First column is in "0" index and so on)
				eg: If test case is saved in 4th column then give value as follows
				ExcelSheetTCColNum=3

	-Executing Program:
		1. In the folder "C:\RQMTestPlanCreator" modify the Generic.Properties files,solutiondata and test cases files.
		2. Double click on the TestPlanCreator.exe.

Help: 
	-If a test case is already added or not found in RQM with same name as passed in excel sheet, then the test case name will be captured
	and sent through E-mail. The user can later conclude if that particular test case is required or not. 
	-If a test suite is already added or not found in RQM with same name as passed in excel sheet, then the test suite ID will be captured
	and sent through E-mail. The user can later conclude if that particular test s uite is required or not.
	-To add/search a test case make sure the columns are starting in this sequence - ID , Priority, Name...
	-To add/search a test suite make sure the columns are starting in this sequence - ID , Priority, Name...
	-To add multiple inputs for SolutionData, please add next value into next row except for To-Email ID.
	-To add multiple inputs To-Email ID , enter different email id separated with a "," .
	-E-mail will also contain TestPlan-Id and number of test cases,number of Test Suites added in the attachment, Composition.txt. 

Author: 
	-Shweta B
	-Chethan Kumar G

Version:
	-Version 1.0





		




		




/* 

		Title / Project							: Hotel Management System
		Language							: C++
		Author								: Tushal Dawani 
		
*/


#include <iostream> 
#include <fstream>  
#include <string>
#include <unistd.h> 


using namespace std;

void display()
{
	
	
	// You must use these two colors --> 4e and 30 , 8e
	system("Color 30");
	cout << "\n\t\t\t****************************************************";
	cout << "\n\t\t\t* WELCOME TO PALM-PARADISE HOTEL MANAGEMENT STSTEM *";
	cout << "\n\t\t\t****************************************************";
	cout << "\n\t\t\t\t  * Propriter - Tushal Dawani *"<<endl;
}

void reserveRoom ()
{
		system("cls");
		system("color 4E");
		
		
		cout << "\n\t\t\t****************************************************";
		cout << "\n\t\t\t* WELCOME TO PALM-PARADISE HOTEL MANAGEMENT STSTEM *";
		cout << "\n\t\t\t****************************************************";
		
		cout << "\n\t\t\t\t  * Propriter - Tushal Dawani *"<<endl;
		
	
		
		int costumer_id;
		char roomType[10];
		char roomClassfication[10];
	    	int room_no;
		char name[50];
	    	char address[70];
	    	char phone[15];
	   	 int days;
		int numberOfDaysToCheckout;
	    	float charges;
	    
	    	cout << "\n----------------------";
	    	cout << "\nEnter Customer Details";
		cout << "\n----------------------";
		
			
    
		ofstream fout("Record.txt", ios::app);
		ofstream rooms("rooms.txt",ios::app);
	

		cout << "\nEnter a new Id for costumer: ";
	    	cin >> costumer_id;
	    	fout <<costumer_id<<endl;
	   	cin.ignore();  // Clear the input buffer to avoid issues with getline
	    
	    
	    cout << "\nRoom no: ";
	    cin >> room_no;
	    fout <<"Room Number : "<<room_no<<endl;
	    rooms<< room_no<<endl;
	    cin.ignore();  // Clear the input buffer to avoid issues with getline
   
        cout << " \nRoom Type (Single(1)/Double(2)/Triple(3)): ";
        cin.getline(roomType, 10);
        fout<<"Room Type : "<<roomType<<endl;
        
        cout << " \nAC(0) / Non-AC(1) : ";
        cin.getline(roomClassfication, 10);
        fout<<"AC / Non-AC : "<<roomClassfication<<endl;
        
        cout << " \nName: ";
        cin.getline(name, 50);  // Now reads the full name properly
        fout<<"Name : "<<name<<endl;

        cout << " \nAddress: ";
        cin.getline(address, 70);  // Now reads the full address properly
        fout<<"Address : "<<address<<endl;

        cout << " \nPhone No: ";
        cin.getline(phone, 15);
        fout<<"Phone : "<<phone<<endl;

        cout << " \nNo of Days to Checkout: ";
        cin >> days;
        fout<<"No.of Days to Checkout : "<<days<<endl;
        cin.ignore();  // Clear the input buffer again before calculating charges
        
        cout << "\n==========================";
		cout << " \nYour Total Charges: ";
		charges = days * 5000;  
		cout << charges;
		fout <<"Charges :  " << charges<<endl;
		fout <<endl<<endl;
		
		cout << "\n==========================";
		cout << endl;
		cout << "Complete reservation details are being verified ";sleep(5);
		cout << "." ; sleep(1);
		cout << "." ; sleep(1);
		cout << "." ; sleep(1);
		sleep(4);
		
		system("cls");
		system("color 4E");
		cout << "\n\nThank you for choosing our Palm Paradise hotel...!" ; sleep(3);
		cout << " \nPlease wait while we process your room reservation";sleep(7);
		cout << "." ; sleep(2);
		cout << "." ; sleep(2);
		cout << "." ; sleep(4);

		
		system("color 2E");
        cout << "\n\n\nDear " << name << ", your reservation for room number " << room_no << " is confrimed now.";
        
        

        cout <<endl<<endl;
        
        system ("PAUSE") ;
	    fout.close();
    
    
}


void searchGuestRecord()
{
	
	system ("cls");
	cout << "\n\t\t\t****************************************************";
	cout << "\n\t\t\t* WELCOME TO PALM-PARADISE HOTEL MANAGEMENT STSTEM *";
	cout << "\n\t\t\t****************************************************";

	
	cout << "\n\t\t\t\t   * Propriter - Tushal Dawani *"<<endl;
	
	cout<< endl;
	cout << "Retrieving data ";sleep(2);
	cout << "." ; sleep(1);
	cout << "." ; sleep(1);
	cout << "." ; sleep(3);
	
	system ("color 8E");
	
	char idForSearch[30];
	string text;
	string arr[9];
	cout << "\n\nEnter Your ID :  ";
    cin>>idForSearch;
    
    ifstream readfile("Record.txt", ios::in );
    
    cout << "\n------------------------";
	cout << "\nUnveiling Guest Details";
	cout << "\n------------------------";
	cout << endl << endl;
	
    while(getline(readfile,arr[8]))
    {
    	if (arr[8]==idForSearch)
		{
			for(int i=1; i<=8; i++)
			{
				getline(readfile,text);
				cout<<text<<endl;
				
			}
		}
		
		
		
	}		
		
	cout <<endl<<endl;
	system ("PAUSE") ;		
    
}


	
void AllocatedRooms() 
{	

	system ("cls");
	system("color 03");
	cout << "\n\t\t\t****************************************************";
	cout << "\n\t\t\t* WELCOME TO PALM-PARADISE HOTEL MANAGEMENT STSTEM *";
	cout << "\n\t\t\t****************************************************";
	
	
	cout << "\n\t\t\t\t   * Propriter - Tushal Dawani *"<<endl;
	
	cout << "\n\n\nOne moment, please" ; sleep(3) ;
	cout << "." ; sleep(1);
	cout << "." ; sleep(1);
	cout << "." ; sleep(2);
	
	cout <<endl<<endl<<endl<<endl<<endl;
	cout << "\n************************";
	cout << "\nAllocated Rooms Details";
	cout << "\n************************"<<endl;
	
	cout << endl;
	

	string line="";
	ifstream read("Record.txt");
	while (getline (read,line))
	{
		cout<<line<<endl;
	}
	
	cout<<endl<<endl;
	

	cout <<endl<<endl;
	system ("PAUSE") ;
	
	
}









int main ()
{
	system("Color 4E");
	system("cls");
	
	
		display();
		int choice;
		int numberOfDaysToCheckout;	
		cout << "\n\n\n\t\t\t1.Reserve A Room"<<endl;
		cout << "\n\t\t\t2.Search Guest Record"<<endl;
//		cout << "\n\t\t\t3.Delete Guest Record"<<endl;
		cout << "\n\t\t\t4.Rooms Allocated"<<endl;
		cout << "\n\t\t\t5.Exit"<<endl;
		cout << "\n\n\t\t\tEnter Your Choice: ";;
		cin >> choice;
		
		while (choice!=5)
	{
		switch(choice){
			
			case 1: 
        			reserveRoom();
					break;
			case 2: 
        			searchGuestRecord();
					break;
//			case 3:  
//        			deleteGuestRecord();
        			
//					break;
		
			case 4: 
					AllocatedRooms();
					break;
			case 5:	
        			system ("color 12");
					system("exit");
					
			default:cout<< "\n\nInvalid Input, Kindly insert the valid input."<<endl<<endl;
			system ("PAUSE") ;
			
			 
					
		
		}
		cout << "\n\n\n\t\t\t1.Reserve A Room"<<endl;
		cout << "\n\t\t\t2.Search Guest Record"<<endl;
//		cout << "\n\t\t\t3.Delete Guest Record"<<endl;
		cout << "\n\t\t\t4.Rooms Allocated"<<endl;
		cout << "\n\t\t\t5.Exit"<<endl;
		cout << "\n\n\t\t\tEnter Your Choice: ";;
		cin >> choice;
		
	}
	
	
}

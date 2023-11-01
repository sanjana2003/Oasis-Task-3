public class AtmMachine
{
	public static int takeIntegerInput(int limit) 
	{
		int input = 0;
		boolean flag = false;
		
		while ( !flag )
		{
			try 
			{
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) 
				{
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e )
			{
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println("** WELCOME TO ANDHRA BANK ATM SYSTEM **");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice: ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) 
		{
			BankAccount n = new BankAccount();
			n.register();
			while(true) 
			{
				System.out.println("1.Login \n2.Exit");
				System.out.print("Enter Your Choice: ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 )
				{
					if (n.login()) 
					{
						System.out.println("\n<--- WELCOME BACK " + n.name + " --->\n");
						boolean isFinished = false;
						while (!isFinished)
						{
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit\n");
							System.out.print("Enter Your Choice: ");
							int c = takeIntegerInput(6);
							switch(c) 
							{
								case 1:
								n.withdraw();
								break;
								case 2:
								n.deposit();
								break;
								case 3:
								n.transfer();
								break;
								case 4:
								n.checkBalance();
								break;
								case 5:
								n.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
								default:System.out.println("Enter valid choice");
							}
						}
					}
				}
				else
				{
					System.exit(0);
				}
			}
		}
		else 
		{
			System.exit(0);
	
		}

		
	}
}
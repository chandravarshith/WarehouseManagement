package warehouse.management;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WarehouseManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Functionalities f = new Functionalities();
		
		System.out.println("Welcome to Warehouse Management\n");
		
		//program loop
		boolean exit = false;
		while(!exit) {
			
			//validating option
			int op = 0;
			while(true) {
				System.out.println("---------Users-----------");
				System.out.println("1. Administrator\n"
								+ "2. Seller\n"
								+ "3. Buyer\n"
								+ "4. Exit");
				System.out.println("-------------------------");
				System.out.print("Choose the option: ");
				try {
					op = sc.nextInt();
					System.out.println();
				}
				catch (InputMismatchException e) {
					op = 0;
			    }
				finally {
					sc.nextLine();
					if(op < 1 || op > 4) {
						System.out.println("Please choose a valid option in the range 1 to 4\n");
					}
					else break;
				}
			}
			
			//Switch case for Home
			switch(op) {
			
				//1. Admin
				case 1:
					System.out.println("_________________Login__________________");
					//login validation
					String number = "";
					String password = "";
					while(true) {
						
						//Admin number Input validation
						while(true) {
							System.out.print("Mobile Number: ");
							number = sc.nextLine();
							if(number.matches("^[0-9]*$")) {
								break;
							}
							else {
								System.out.println("Please enter a valid Mobile Number!\n");
							}
						}
						
						//Password
						System.out.print("Password: ");
						password = sc.nextLine();
						
						if(f.adminLogin(number,password)) {
							System.out.println("________________________________________\n");
							break;
						}
					}
					
					boolean adminLogin = true;
					while(adminLogin) {
					
						//Admin option validation
						int adminOp = 0;
						while(true) {
							System.out.println("----------Admin Menu----------");
							System.out.println("1. View Seller details\n"
											+ "2. Delete Seller details\n"
											+ "3. View Stock Availability\n"
											+ "4. View entire stock\n"
											+ "5. Logout");
							System.out.println("------------------------------");
							System.out.print("Choose the option: ");
							try {
								adminOp = sc.nextInt();
								System.out.println();
							}
							catch (InputMismatchException e) {
								adminOp = 0;
						    }
							finally {
								sc.nextLine();
								if(adminOp < 1 || adminOp > 5) {
									System.out.println("Please choose a valid option in the range 1 to 5\n");
								}
								else break;
							}
						}
						
						
						//Admin options
						switch(adminOp) {
						
							//1. View Seller details
							case 1:
								//Seller number Input validation
								String sellerNumber = "";
								while(true) {
									System.out.print("Enter Seller Mobile Number: ");
									sellerNumber = sc.nextLine();
									if(sellerNumber.matches("^[0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Mobile Number!\n");
									}
								}
								
								f.displaySellerDetails(sellerNumber);
								
								break;
								
							//2. Delete Seller details
							case 2:
								//Seller number Input validation
								String sellerNumber1 = "";
								while(true) {
									System.out.print("Enter Seller Mobile Number: ");
									sellerNumber1 = sc.nextLine();
									if(sellerNumber1.matches("^[0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Mobile Number!\n");
									}
								}
								
								f.removeSellerDetails(sellerNumber1);
								
								break;
								
							//3. View Stock Availability
							case 3:
								//stock ID validation
								String stockId = "";
								while(true) {
									System.out.print("Enter Stock ID: ");
									stockId = sc.nextLine();
									if(stockId.matches("^[a-zA-Z0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Stock ID!\n");
									}
								}
								
								f.viewAvailabilityOfStock(stockId);
								
								break;
								
							//4. View entire stock
							case 4:
								f.displayStock();
								break;
								
							//5. Logout
							case 5:
								adminLogin = false;
								System.out.println("\nLogout Successful!\n");
								break;
						}
					
					}
										
					break;
					
				//2. Seller
				case 2:
					
					//Seller option validation
					int loginOp = 0;
					while(true) {
						System.out.println("----------Login Menu----------");
						System.out.println("1. Login\n"
										+ "2. Register");
						System.out.println("------------------------------");
						System.out.print("Choose the option: ");
						try {
							loginOp = sc.nextInt();
							System.out.println();
						}
						catch (InputMismatchException e) {
							loginOp = 0;
					    }
						finally {
							sc.nextLine();
							if(loginOp < 1 || loginOp > 2) {
								System.out.println("Please choose a valid option\n");
							}
							else break;
						}
					}
					
					boolean userCheck = false;
					while(!userCheck) {
						if(loginOp == 1) {	
							System.out.println("_________________Login__________________");	
								
							//login validation
							String sellerNumber = "";
							String sellerPassword = "";
							while(true) {
								
								//Seller number Input validation
								while(true) {
									System.out.print("Mobile Number: ");
									sellerNumber = sc.nextLine();
									if(sellerNumber.matches("^[0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Mobile Number!\n");
									}
								}
								
								//Password
								System.out.print("Password: ");
								sellerPassword = sc.nextLine();
								int loginStatus = f.sellerLogin(sellerNumber,sellerPassword);
								if(loginStatus == 0) {
									userCheck = true;
									System.out.println("________________________________________\n");
									break;
								}
								else if (loginStatus == 1) {
									System.out.println("________________________________________\n");
									loginOp = 2;
									break;
								}
							}
						}
						
						if(loginOp == 2) {
							System.out.println("_________________Register__________________");	
							
							String name = "";
							while(true) {
								System.out.print("Seller Name: ");
								name = sc.nextLine();
								if(name.matches("^[a-zA-Z ]*$")) {
									break;
								}
								else {
									System.out.println("Please enter a valid Name!\n");
								}
							}
							
							//Seller number validation
							String sellerNumber = "";
							while(true) {
								System.out.print("Mobile Number: ");
								sellerNumber = sc.nextLine();
								if(sellerNumber.matches("^[0-9]*$")) {
									break;
								}
								else {
									System.out.println("Please enter a valid Mobile Number!\n");
								}
							}
							
							if(f.setSellerIndex(sellerNumber) != null) {
								System.out.println("\nSeller account already exists. Please Login!\n");
								loginOp = 1;
								continue;
							}
							
							//Password validation
							String sellerPassword = "";
							String confirmPassword = "";
							while(true) {
								System.out.print("Password: ");
								sellerPassword = sc.nextLine();
								
								System.out.print("Confirm Password: ");
								confirmPassword = sc.nextLine();
								
								if(sellerPassword.equals(confirmPassword)) {
									break;
								}
								else {
									System.out.println("Confirm password should be the same as Password!\n");
								}
							}
							
							f.registerSeller(new Seller(name,sellerNumber,sellerPassword));
							System.out.println("\nRegistration Successful!");
							userCheck = true;
							System.out.println("___________________________________________\n");
						}
					}
					
					boolean sellerLogin = true;
					while(sellerLogin) {
						//Seller option validation
						int sellerOp = 0;
						while(true) {
							System.out.println("----------Seller Menu----------");
							System.out.println("1. View Stock availability\n"
											+ "2. Add Stock to warehouse\n"
											+ "3. Number of orders\n"
											+ "4. Delivery\n"
											+ "5. Logout");
							System.out.println("------------------------------");
							System.out.print("Choose the option: ");
							try {
								sellerOp = sc.nextInt();
								System.out.println();
							}
							catch (InputMismatchException e) {
								sellerOp = 0;
						    }
							finally {
								sc.nextLine();
								if(sellerOp < 1 || sellerOp > 5) {
									System.out.println("Please choose a valid option in the range 1 to 5\n");
								}
								else break;
							}
						}
						
						//Seller options
						switch(sellerOp) {
							//1. View stock availability
							case 1:
								//StockId input validation
								String tagId = "";
								while(true) {
									System.out.print("Enter Stock ID: ");
									tagId = sc.nextLine();
									if(tagId.matches("^[a-zA-Z0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Stock ID!\n");
									}
								}
								
								f.viewAvailabilityOfStock(tagId);
								
								break;
								
							//2. Add stock to warehouse
							case 2:
								System.out.println("Please, provide the following Stock details:");
								String stockId = "";
								while(true) {
									System.out.print("Tag ID: ");
									stockId = sc.nextLine();
									if(stockId.matches("^[a-zA-Z0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Stock ID!\n");
									}
								}
								
								String name = "";
								while(true) {
									System.out.print("Name: ");
									name = sc.nextLine();
									if(name.matches("^[a-zA-Z ]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid name!\n");
									}
								}
								
								int availableQuantity = -1;
								while(true){
									try {
										System.out.print("Quantity: ");
										availableQuantity = sc.nextInt();
									}
									catch (InputMismatchException e) {
										availableQuantity = -1;
								    }
									finally {
										sc.nextLine();
										if(availableQuantity < 0 || availableQuantity > 1000000) {
											System.out.println("Please enter the quantity only in the range of 0 to 1000000!\n");
										}
										else break;
									}
								}
								
								Double price = -1.0;
								while(true){
									try {
										System.out.print("Price: ");
										price = sc.nextDouble();
									}
									catch (InputMismatchException e) {
										price = -1.0;
								    }
									finally {
										sc.nextLine();
										if(price < 0.0 || price > 1000000.0) {
											System.out.println("Please enter the price only in the range of 0.0 to 1000000.0!\n");
										}
										else break;
									}
								}
								
								f.addStockDetails(stockId, name, availableQuantity, price);
								System.out.println("\nStock added to warehouse successfully!\n");
								break;
								
							//3. Number of orders
							case 3:
								f.displaySellerOrders();
								break;
								
							//4. Delivery
							case 4:
								//OrderId input validation
								String orderId = "";
								while(true) {
									System.out.print("Enter Order ID: ");
									orderId = sc.nextLine();
									if(orderId.matches("^[a-zA-Z0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Order ID!\n");
									}
								}
								
								System.out.print("Did buyer accept the delivery(Yes/No): ");
								String delivery = "";
								while(true) {
									delivery = sc.nextLine();
									if(delivery.equalsIgnoreCase("Yes")) {
										f.updateSellerOrders(orderId);
										System.out.println("\nOrder delivered to the Buyer Successfully!\n");
										break;
									}
									else if(delivery.equalsIgnoreCase("No")) {
										System.out.println("\nPlease delivery the order to the Buyer!\n");
										break;
									}
								}
								break;
								
							//5. Logout
							case 5:
								sellerLogin = false;
								System.out.println("\nLogout Successful!\n");
								break;
								
						}
					}
					break;
					
				//3. Buyer
				case 3:
					//Buyer option validation
					int loginOp1 = 0;
					while(true) {
						System.out.println("----------Login Menu----------");
						System.out.println("1. Login\n"
										+ "2. Register");
						System.out.println("------------------------------");
						System.out.print("Choose the option: ");
						try {
							loginOp1 = sc.nextInt();
							System.out.println();
						}
						catch (InputMismatchException e) {
							loginOp1 = 0;
					    }
						finally {
							sc.nextLine();
							if(loginOp1 < 1 || loginOp1 > 2) {
								System.out.println("Please choose a valid option\n");
							}
							else break;
						}
					}
					
					boolean userCheck1 = false;
					while(!userCheck1) {
						if(loginOp1 == 1) {	
							System.out.println("_________________Login__________________");	
								
							//login validation
							String buyerNumber = "";
							String buyerPassword = "";
							while(true) {
								
								//Seller number Input validation
								while(true) {
									System.out.print("Mobile Number: ");
									buyerNumber = sc.nextLine();
									if(buyerNumber.matches("^[0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Mobile Number!\n");
									}
								}
								
								//Password
								System.out.print("Password: ");
								buyerPassword = sc.nextLine();
								int loginStatus = f.buyerLogin(buyerNumber,buyerPassword);
								if(loginStatus == 0) {
									userCheck1 = true;
									System.out.println("________________________________________\n");
									break;
								}
								else if(loginStatus == 1) {
									loginOp1 = 2;
									System.out.println("________________________________________\n");
									break;
								}
							}
						}
						if(loginOp1 == 2) {
							System.out.println("_________________Register__________________");	
							
							String name = "";
							while(true) {
								System.out.print("Buyer Name: ");
								name = sc.nextLine();
								if(name.matches("^[a-zA-Z ]*$")) {
									break;
								}
								else {
									System.out.println("Please enter a valid Name!\n");
								}
							}
							
							//Seller number validation
							String buyerNumber = "";
							while(true) {
								System.out.print("Mobile Number: ");
								buyerNumber = sc.nextLine();
								if(buyerNumber.matches("^[0-9]*$")) {
									break;
								}
								else {
									System.out.println("Please enter a valid Mobile Number!\n");
								}
							}
							
							if(f.setBuyerIndex(buyerNumber) != null) {
								System.out.println("\nBuyer account already exists. Please Login!\n");
								loginOp1 = 1;
								continue;
							}
							
							//Password validation
							String buyerPassword = "";
							String confirmPassword = "";
							while(true) {
								System.out.print("Password: ");
								buyerPassword = sc.nextLine();
								
								System.out.print("Confirm Password: ");
								confirmPassword = sc.nextLine();
								
								if(buyerPassword.equals(confirmPassword)) {
									break;
								}
								else {
									System.out.println("Confirm password should be the same as Password!\n");
								}
							}
							
							f.registerBuyer(new Buyer(name,buyerNumber,buyerPassword));
							System.out.println("\nRegistration Successful!");
							userCheck1 = true;
							System.out.println("___________________________________________\n");
						}
					}
					
					boolean buyerLogin = true;
					while(buyerLogin) {
					
						//Buyer option validation
						int buyerOp = 0;
						while(true) {
							System.out.println("----------Buyer Menu----------");
							System.out.println("1. View and buy Products\n"
											+ "2. View Orders\n"
											+ "3. Add Address\n"
											+ "4. Edit Address\n"
											+ "5. Delete Address\n"
											+ "6. Logout");
							System.out.println("------------------------------");
							System.out.print("Choose the option: ");
							try {
								buyerOp = sc.nextInt();
								System.out.println();
							}
							catch (InputMismatchException e) {
								buyerOp = 0;
						    }
							finally {
								sc.nextLine();
								if(buyerOp < 1 || buyerOp > 6) {
									System.out.println("Please choose a valid option in the range 1 to 6\n");
								}
								else break;
							}
						}
						
						//Buyer options
						switch(buyerOp) {
						
							//1. View and buy Products
							case 1:
								f.viewProducts();
								System.out.print("Buy Products(Yes/No): ");
								String buyOp = "";
								while(true) {
									buyOp = sc.nextLine();
									System.out.println();
									if(buyOp.equalsIgnoreCase("Yes")) {
										//Stock input validation
										String stockId = "";
										while(true) {
											System.out.print("Enter Product ID: ");
											stockId = sc.nextLine();
											if(stockId.matches("^[a-zA-Z0-9]*$")) {
												break;
											}
											else {
												System.out.println("Please enter a valid Product ID!\n");
											}
										}
										
										//order quantity validation
										int orderQuantity = -1;
										while(true){
											try {
												System.out.print("Enter Order Quantity: ");
												orderQuantity = sc.nextInt();
											}
											catch (InputMismatchException e) {
												orderQuantity = -1;
										    }
											finally {
												sc.nextLine();
												if(orderQuantity < 0 || orderQuantity > 1000000) {
													System.out.println("Please enter the quantity only in the range of 0 to 1000000!\n");
												}
												else break;
											}
										}
										
										f.placeOrder(stockId,orderQuantity);
										break;										
									}
									else if(buyOp.equalsIgnoreCase("No")) {
										break;
									}
									else {
										System.out.println("Please enter Yes or No!\n");
									}
								}
								
								break;
								
							//2. View Orders
							case 2:
								f.displayBuyerOrders();
								break;
								
							//3. Add Address
							case 3:
								System.out.println("Please enter the following details:\n");
								//name validation
								String name = "";
								while(true) {
									System.out.print("Name: ");
									name = sc.nextLine();
									if(name.matches("^[a-zA-Z ]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Name!\n");
									}
								}
								
								// number validation
								String number1 = "";
								while(true) {
									System.out.print("Mobile Number: ");
									number1 = sc.nextLine();
									if(number1.matches("^[0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Mobile Number!\n");
									}
								}
								
								String doorNum = "";
								while(true) {
									System.out.print("Door number: ");
									doorNum = sc.nextLine();
									if(doorNum.matches("^[0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Door Number!\n");
									}
								}
								
								String area = "";
								while(true) {
									System.out.print("Area/Locality: ");
									area = sc.nextLine();
									if(area.matches("^[a-zA-Z ]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Area!\n");
									}
								}
								
								String city = "";
								while(true) {
									System.out.print("City: ");
									city = sc.nextLine();
									if(city.matches("^[a-zA-Z ]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid City!\n");
									}
								}
								
								String state = "";
								while(true) {
									System.out.print("State: ");
									state = sc.nextLine();
									if(state.matches("^[a-zA-Z ]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid State!\n");
									}
								}
								
								String areaCode = "";
								while(true) {
									System.out.print("Area Code: ");
									areaCode = sc.nextLine();
									if(areaCode.matches("^[0-9]*$")) {
										break;
									}
									else {
										System.out.println("Please enter a valid Area Code!\n");
									}
								}
								
								f.addAddressToBuyer(name,number1,doorNum,area,city,state,areaCode);
								
								break;
								
							//4. Edit Address
							case 4:
								if(!f.displayAddresses()) break;
								System.out.println("Select the Serial Number of Address to edit: ");
								int serialNum = 0;
								while(true){
									try {
										System.out.print("Serial Number: ");
										serialNum = sc.nextInt();
									}
									catch (InputMismatchException e) {
										serialNum = -1;
								    }
									finally {
										sc.nextLine();
										if(serialNum < 0 || serialNum > f.getNumberOfAddress()) {
											System.out.println("Please select a valid Serial Number!\n");
										}
										else break;
									}
								}
								
								//Buyer option validation
								int editOp = 0;
								while(true) {
									System.out.println("----------Edit Address----------");
									System.out.println("1. Name\n"
													+ "2. Mobile Number\n"
													+ "3. Door Number\n"
													+ "4. Area/Locality\n"
													+ "5. City\n"
													+ "6. State\n"
													+ "7. Area Code");
									System.out.println("--------------------------------");
									System.out.print("Choose the option: ");
									try {
										editOp = sc.nextInt();
										System.out.println();
									}
									catch (InputMismatchException e) {
										editOp = 0;
								    }
									finally {
										sc.nextLine();
										if(editOp < 1 || editOp > 7) {
											System.out.println("Please choose a valid option in the range 1 to 7\n");
										}
										else if(editOp == 5) break;
										else break;
									}
								}
								
								//edit switch
								switch(editOp) {
									case 1:
										//name validation
										String name1 = "";
										while(true) {
											System.out.print("Enter New Name: ");
											name1 = sc.nextLine();
											if(name1.matches("^[a-zA-Z ]*$")) {
												break;
											}
											else {
												System.out.println("Please enter a valid Name!\n");
											}
										}
										f.editAddress(serialNum,editOp,name1);
										break;
										
									case 2:
										// number validation
										String number2 = "";
										while(true) {
											System.out.print("Enter New Mobile Number: ");
											number2 = sc.nextLine();
											if(number2.matches("^[0-9]*$")) {
												break;
											}
											else {
												System.out.println("Please enter a valid Mobile Number!\n");
											}
										}
										f.editAddress(serialNum,editOp,number2);
										break;
										
									case 3:
										String doorNum1 = "";
										while(true) {
											System.out.print("Enter New Door number: ");
											doorNum1 = sc.nextLine();
											if(doorNum1.matches("^[0-9]*$")) {
												break;
											}
											else {
												System.out.println("Please enter a valid Door Number!\n");
											}
										}
										f.editAddress(serialNum,editOp,doorNum1);
										break;
								
									case 4:
										String area1 = "";
										while(true) {
											System.out.print("Enter New Area/Locality: ");
											area1 = sc.nextLine();
											if(area1.matches("^[a-zA-Z ]*$")) {
												break;
											}
											else {
												System.out.println("Please enter a valid Area!\n");
											}
										}
										f.editAddress(serialNum,editOp,area1);
										break;
								
									case 5:
										String city1 = "";
										while(true) {
											System.out.print("Enter New City: ");
											city1 = sc.nextLine();
											if(city1.matches("^[a-zA-Z ]*$")) {
												break;
											}
											else {
												System.out.println("Please enter a valid City!\n");
											}
										}
										f.editAddress(serialNum,editOp,city1);
										break;
								
									case 6:
										String state1 = "";
										while(true) {
											System.out.print("Enter New State: ");
											state1 = sc.nextLine();
											if(state1.matches("^[a-zA-Z ]*$")) {
												break;
											}
											else {
												System.out.println("Please enter a valid State!\n");
											}
										}
										f.editAddress(serialNum,editOp,state1);
										break;
								
									case 7:
										String areaCode1 = "";
										while(true) {
											System.out.print("Enter New Area Code: ");
											areaCode1 = sc.nextLine();
											if(areaCode1.matches("^[0-9]*$")) {
												break;
											}
											else {
												System.out.println("Please enter a valid Area Code!\n");
											}
										}
										f.editAddress(serialNum,editOp,areaCode1);
										break;
								}
								break;
								
							//5. Delete Address
							case 5:
								f.displayAddresses();
								System.out.println("Select the Serial Number of Address to edit: ");
								int serialNum1 = 0;
								while(true){
									try {
										System.out.print("Serial Number: ");
										serialNum1 = sc.nextInt();
									}
									catch (InputMismatchException e) {
										serialNum1 = -1;
								    }
									finally {
										sc.nextLine();
										if(serialNum1 < 0 || serialNum1 > f.getNumberOfAddress()) {
											System.out.println("Please select a valid Serial Number!\n");
										}
										else break;
									}
								}
								f.deleteAddress(serialNum1);
								break;
						
							//6. Logout
							case 6:
								buyerLogin = false;
								System.out.println("\nLogout Successful!\n");
								break;
								
						}
					
					}
					
					break;
					
				//4. EXit
				case 4:
					System.out.println("\nThank you!\n");
					exit = true;
					break;
				
			}
			
		}
		sc.close();
	}

}

package testing;


import java.util.List;
import java.util.ArrayList;
import javax.swing.*;


import testing.userSeatSelection;
import testing.LuggageRefNum.Luggage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FlightApp extends JFrame {

		public CardLayout cardLayout;
		public JPanel cardPanel;
		public List<UserAcc> userAccount;

	     private JComboBox<String> cityComboBox;
		 private JTextArea flightInfoTextArea;
		 private userSeatSelection[] seats;
		 private LuggageRefNum luggageRefNum;
		 private Cart userCart;
		
		public int flightcount = 0;
		
		
		public FlightApp() {
			setTitle("Flight Booking/Tracking App");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	setSize(800,800);
	     	
	     	
			///PANELS THAT WILL APPEAR
	     	
			cardLayout = new CardLayout();
			cardPanel = new JPanel(cardLayout);
			
			
			userAccount = new ArrayList<>();
			luggageRefNum = LuggageRefNum.getInstance();
			userCart = new Cart("", new ArrayList<>(), "", 0);
			
			
			
			cardPanel.add(createAccountPanel(), "CREATE ACCOUNT");
			cardPanel.add(createLoginPanel(), "LOGIN");
			cardPanel.add(createHomepagePanel(), "HOME PAGE");
			cardPanel.add(createSeatSelectorPanel(), "SEAT SELECTION");
			cardPanel.add(createLuggagePanel(), "LUGGAGE");
			cardPanel.add(createViewCartPanel(), "VIEW CART");
		
			cardLayout.show(cardPanel, "CREATE ACCOUNT");
			add(cardPanel);
			setVisible(true);
	
			
		}
		
		///class to represent the user accounts
		public static class UserAcc{
			public String username;
			public String password;
			
			
			public UserAcc(String username, String password) {
				this.username = username;
				this.password = password;
				
			}
			 
			public String getUser() {
				 return username;
				 
			 }
			 public String getPw() {
				 return password;
			 }
			
		}
		////CHECKING IF USERNAME IS TAKEN
		public boolean isUsernameTaken(String username) {
			for(UserAcc user : userAccount) {
				if (user.getUser().equals(username)) {
					return true;
				}
			}
			return false;
		}
		///// CHECKING FOR VALID LOGIN 
		public boolean ValidLogin(String username, String password) {
			for(UserAcc user : userAccount) {
				if(user.getUser().equals(username) && user.getPw().equals(password)) {
					return true;
				}
			}
			return false;
		}
	
		///CREATION FOR USER TO MAKE AN ACCOUNT
		
		public JPanel createAccountPanel() {

			JPanel panel = new JPanel(new GridLayout(4,2));
			
			JLabel userlabel = new JLabel("Create a username: ");
			JTextField usertextField = new JTextField();
			JLabel pwLabel =  new JLabel("Create a password: ");
			JPasswordField pwField = new JPasswordField();
			
			JButton createAccButton = new JButton("Create Account");
			createAccButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e) {
					
					String username = usertextField.getText();
					String password = new String(pwField.getPassword());
					
					///checking for already made accounts
					if(isUsernameTaken(username)) {
						JOptionPane.showMessageDialog(null, "Username taken. Choose another.");
						
					}else {
						UserAcc newUser = new UserAcc(username, password);
						userAccount.add(newUser);
					}
					
					///letting user know account was made and switching to home page
					System.out.println("Account has been created.");
					
					cardLayout.show(cardPanel, "HOME PAGE");
				}

				
			});
			panel.add(userlabel);
			panel.add(usertextField);
			panel.add(pwLabel);
			panel.add(pwField);
			panel.add(createAccButton);
						
			return panel;
			
		}
		
		//// CREATION FOR USERS TO LOGIN TO THEIR ACCOUNT

		public JPanel createLoginPanel() {
			JPanel panel = new JPanel(new GridLayout(3,2));
			
			JLabel userlabel = new JLabel("Username: ");
			JTextField usertextField = new JTextField();
			JLabel pwLabel =  new JLabel("Password: ");
			JPasswordField pwField = new JPasswordField();
			
			JButton loginButton = new JButton("Log in");
			
			loginButton.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e) {
				String username = usertextField.getText();
				String password = new String(pwField.getPassword());
				
				if(ValidLogin(username, password)) {
					
					cardLayout.show(cardPanel, "HOME PAGE");
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Username/Password");
				}
				
			}
		});
				
			panel.add(userlabel);
			panel.add(usertextField);
			panel.add(pwLabel);
			panel.add(pwField);
			panel.add(loginButton);
			
			return panel;
		

		}
		
		/// HOME PAGE OF THE FLIGHT APP

		public JPanel createHomepagePanel() {
			
			
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Flight Home Page");
			
			///user input Field being created
			JTextField userInput = new JTextField();
			userInput.setPreferredSize(new Dimension(250,40));
			
			
			
			///CREATING CITY BOX DISPLAY
			cityComboBox = new JComboBox<>();
	        populateCityComboBox();

	        flightInfoTextArea = new JTextArea(10, 30);
	        flightInfoTextArea.setEditable(false);
	        
	        JLabel chooseFlightlabel = new JLabel("Choose the city you want to go to:");

	        JButton chooseCityButton = new JButton("Select");
	        
	        
	        chooseCityButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String selectedCity = (String) cityComboBox.getSelectedItem();
	                if (selectedCity != null) {
	                    displayFlights(selectedCity);
	                    
	                   
	                }
	            }
	        });
	        
	    	///BUTTON CREATION FOR HOME PAGE
			JButton enterButton = new JButton("Enter");
			enterButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            String selectedFlight = userInput.getText();
		            userCart.setUsersFlight(selectedFlight);
		            
		            try {
		            	int flightNum = Integer.parseInt(selectedFlight);
		            	if(flightNum > 0 && flightNum <= flightcount ) {
		                
		            		
		            int paymentNumber = LuggageRefNum.getInstance().generatePaymentNum();
		            System.out.println("Your payment number is: " + paymentNumber);
		            userCart.setPaymentNumber(paymentNumber);
		            cardLayout.show(cardPanel, "SEAT SELECTION");
		            
		            	} else {
		            		JOptionPane.showMessageDialog(null, "Invalid Flight Number");
		            	}
		        }catch (NumberFormatException ex) {
		        	JOptionPane.showMessageDialog(null, "Enter Numeric Value");
		        }
		           }
		        }); 
			
			JButton viewCartButton = new JButton("View Cart");
			
			viewCartButton .addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cardLayout.show(cardPanel, "VIEW CART");
				}
			});
			
		    
			JButton logoutButton = new JButton("Logout");
			
			logoutButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					cardLayout.show(cardPanel, "LOGIN");
					
				}
				
			});
			
			panel.add(label);
			panel.add(chooseFlightlabel);
			
			panel.add(cityComboBox);
	        panel.add(chooseCityButton);
	        panel.add(flightInfoTextArea);
			
			panel.add(logoutButton);
			panel.add(viewCartButton);
			

			panel.add(userInput);
			panel.add(enterButton);
			
			
			
			return panel;
			
		}
		
		///PAGE THAT LETS USERS SELECT SEATS ON THE FLIGHTS
		
		public JPanel createSeatSelectorPanel() {
			
			JPanel panel = new JPanel(new BorderLayout());
			JPanel buttonPanel = new JPanel();
			
			JLabel seatLabel = new JLabel("Select your seat(s): ");
			JButton confirmButton = new JButton("Confirm");
			
			confirmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					confirmSeatSelection();
					
					List<String> userSeats = new ArrayList<>();
					for(userSeatSelection seat: seats) {
						if(seat !=null && seat.occupied()) {
							userSeats.add("Seat " + seat.getseatNum());
						}
					}
					userCart.setUsersSeats(userSeats);
					
				}
			});
			
			JPanel seatPanel = new JPanel(new GridLayout(2,5));
			
			seats = new userSeatSelection[15];
			
			for(int i=0; i< seats.length; i++) {
				final int seatIndex = i; 
				seats[i] = new userSeatSelection(i + 1, 5.0 *(i+1));
				seats[i].setSeats(seats);
				
				JButton seatButton = new JButton("Seat " + (i+1));
				seatButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						seatButtonUsed(seats[seatIndex]);
					}
				});
				seatPanel.add(seatButton);
			}
			
			JButton luggageCheckButton = new JButton("Check-in Luggage");
			luggageCheckButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(cardPanel, "LUGGAGE");
				}
			});
			
			buttonPanel.add(confirmButton);
			buttonPanel.add(luggageCheckButton);
			
		    panel.add(seatLabel, BorderLayout.NORTH);
		    panel.add(seatPanel, BorderLayout.CENTER);
		    panel.add(buttonPanel, BorderLayout.SOUTH);
		    
			return panel;
		}
		//CHECK IN LUGGAGE PAGE
		public JPanel createLuggagePanel() {
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			JLabel sizeLabel = new JLabel("Enter luggage weight (lbs): ");
			JTextField sizeField = new JTextField(5);
			JLabel colorLabel = new JLabel("Enter luggage color: ");
			JTextField colorField = new JTextField(5);
			JLabel brandLabel = new JLabel("Enter luggage brand: ");
			JTextField brandField = new JTextField(5);
			
		
			JButton checkInButton = new JButton("Check In");
			checkInButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weight = Integer.parseInt(sizeField.getText());
					String color = colorField.getText();
					String brand = brandField.getText();
					
				    Luggage luggage = luggageRefNum.new Luggage(weight, color, brand, luggageRefNum.generateReferenceNum());
					luggageRefNum.addLuggage(luggage);
					
					cardLayout.show(cardPanel, "VIEW CART");
				   
				}
			});
	
			panel.add(sizeLabel);
			panel.add(sizeField);
			panel.add(colorLabel);
			panel.add(colorField);
			panel.add(brandLabel);
			panel.add(brandField);
			panel.add(checkInButton);
			
			return panel;
		}
		

		
		public JPanel createViewCartPanel() {
			JPanel panel = new JPanel(new GridLayout(4, 2));
			

			JLabel flightLabel = new JLabel("Selected Flight: " + userCart.getUsersFlight());//variable, flight: + whatever flight selected
			JLabel seatsLabel = new JLabel("Selected Seats: " + userCart.getUsersSeats());//variable, flight: + selected seats. true?
			JLabel referenceLabel = new JLabel("Reference Number "+ LuggageRefNum.Luggage.class);
			JLabel paymentLabel = new JLabel("Payment Number: "); //+ LuggageRefNum.getInstance().generatePaymentNum()); //+ paymentNumber
			JLabel totalPrice = new JLabel("Total Price: ");
			
			
			JLabel flightValue = new JLabel(userCart.getUsersFlight());
			List<String> selectedSeats = userCart.getUsersSeats();
			String seatsText = (selectedSeats != null) ? selectedSeats.toString() : "No seats selected";
			JLabel seatValue = new JLabel(seatsText);
			JLabel referenceValue = new JLabel(userCart.getReferenceNumber());
			JLabel paymentValue = new JLabel(String.valueOf(userCart.getPaymentNumber()));
			
			
			panel.add(flightLabel);
			panel.add(flightValue);
			panel.add(seatsLabel);
			panel.add(seatValue);
			panel.add(referenceLabel);
			panel.add(referenceValue);
			panel.add(paymentLabel);
			panel.add(paymentValue);
			panel.add(totalPrice);
			
			return panel;
		}
	
		public void confirmSeatSelection() {
			double totalPrice = 0.0;
			
			
			System.out.println("Confirm Seats: ");
			
			for(userSeatSelection seat : seats) {
				seat.display();
				if(seat.occupied()){
					totalPrice += seat.getPrice();
					
					
				}
			}
			System.out.println("Total Price: " +totalPrice);


			
		}
		
		
		public void seatButtonUsed(userSeatSelection seat) {
			seat.displaySetting();
			if(!seat.occupied()) {
				seat.occupy();
				System.out.println("Seat " + seat.getseatNum());
			}else {
				seat.vacate();
				System.out.println("Seat " + seat.getseatNum());
				
			}
		}
	
		public void populateCityComboBox() {
	       ////change path if needed to run on your computer
			
	        String filePath = "departure.csv";

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] row = line.split(",");
	                if (row.length > 2) {
	                    cityComboBox.addItem(row[2]);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void displayFlights(String selectedCity) {
	    	
	        String filePath = "departure.csv";

	        StringBuilder flightsInfo = new StringBuilder();

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            
	            int flightNum = 1;
	           
	            while ((line = reader.readLine()) != null) {
	                String[] row = line.split(",");
	                if (row.length > 2 && row[2].equalsIgnoreCase(selectedCity)) {
	                	flightsInfo.append("Flight: ").append(flightNum).append("\n");
	                    flightsInfo.append("Scheduled Time: ").append(row[0]).append("\n");
	                    flightsInfo.append("Updated Time: ").append(row[1]).append("\n");
	                    flightsInfo.append("Airline: ").append(row[3]).append("\n\n");
	                    flightNum++;
	                    flightcount++;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        flightInfoTextArea.setText(flightsInfo.toString());
	    }
	
		
		///RUNNING THE FLIGHT APP
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new FlightApp();
				}
			});
		}
		
	}	

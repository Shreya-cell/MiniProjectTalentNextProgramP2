import java.util.*;  /* this project is used to check out and check in the video and rating the videos*/
class Video{
	String videoName;
	boolean checkout;
	int rating;
	String getName() {
		return this.videoName;
	}
	void docheckOut() {
		this.checkout= true;
	}
	void doreturn() {
		this.checkout= false;
	}
	void recieveRating(int rating) {
		this.rating = rating;
	}
	int getRating() {
		return this.rating;
	}
	boolean getCheckOut() {
		return false;
	}
	Video(String name){
		this.videoName = name;
		this.checkout = false;
		this.rating=0;
	}
}
class VideoStore{
	Video[] store = new Video[100];
	int i=0;
	static int c=0;
	void addVideo(String video) {
		Video v = new Video(video);
		c++;
		store[i++] = v;
		System.out.println("Video \""+video+"\" added successfully.");
	}
	void docheckout(String name) {
		int found=0;
		for(int i=0;i<c;i++) {
			if(name.equals(store[i].videoName)) {
				store[i].docheckOut();
				found++;
				System.out.println("Video \""+name+"\" checked out successfully.");
				break;
			}
		}
		if(found == 0)
			System.out.println("Video \""+name+"\" is not found in video rental inventory system.");
	}
	void doReturn(String name) {
		int found=0;
		for(int i=0;i<c;i++) {
			if(store[i].checkout== true) {
				found++;
				store[i].doreturn();
				System.out.println("Video \""+name+"\" returned successfully.");
			}
		}
		if(found==0)
			System.out.println("Video \""+name+"\" is not found in video rental inventory system.");
			
	}
	void receiveRating(String name, int rating) {
		int found=0;
		for(int i=0;i<c;i++) {
			if(name.equals(store[i].videoName)) {
				store[i].recieveRating(rating);
				found++;
				System.out.println("Rating \""+rating+"\" has been mapped to the Video \""+name+"\"");
				break;
			}
		}
		if(found==0)
			System.out.println("Video \""+name+"\" is not found in video rental inventory system.");
			
		
	}
	void listInventory() {
		Video v;
		if(c!=0) {
			System.out.println("--------------------------------------------------------");
			System.out.printf("%-20s|%-20s|%-20s","Vidoe Name","Checkout Status","Rating");
			System.out.println();
			for(int i=0;i<c;i++) {
			v = store[i];
			System.out.printf("%-20s|%-20s|%-20s",v.videoName,v.checkout,v.rating);
			System.out.println();
			}
			System.out.println("--------------------------------------------------------");
		}
		else
			System.out.println("Video Inventory System is Empty.");
	}
	
}
public class P2 {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VideoStore vs = new VideoStore();
		int ch=0;
		String s="";
		do {
			System.out.println("MAIN MENU:");
			System.out.print("1.Add Videos:\n2.Check Out Video:\n3.Return Video:\n4.Receive Rating:\n5.List Inventory\n6.Exit:\nEnter your choice(1..6):");
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the name of the video you want to add:");
				vs.addVideo(sc.next());
				break;
			case 2:System.out.print("Enter the name of the video you want to check out:");
				s = sc.next();
				vs.docheckout(s);
				break;
			case 3:System.out.print("Enter the name of the video you want to Return:");
					s = sc.next();
					vs.doReturn(s);
				break;
			case 4:
				System.out.print("Enter the name of the video you want to Rate:");
				 s = sc.next();
				System.out.print("Enter the rating for this video:");
				int rat = sc.nextInt();
				vs.receiveRating(s,rat);
				break;
			case 5:vs.listInventory();
				break;
			case 6:System.out.println("Exiting...!! Thanks for using the application.");
				System.exit(1);
				break;
			default:System.out.println("Wrong choice");
				break;
			}
		}while(ch!=6);
		sc.close();
	}
	
}

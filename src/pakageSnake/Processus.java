package pakageSnake;

public class Processus implements Runnable{
	private int X;
	private int Y;
	private Thread t;
	public Processus () {
		
		t = new Thread() {
		     public void run() {
		       System.out.println("Mon traitement");
		    }
		    };
		
	}
	public int deplacementX(int direction,int postitonX) {
		//disposition nor sud ouest est
		//   0
		// 3   1
		//   2
		switch(direction){
		case 0:
			X= postitonX--;
			break;
		case 1:
			break;
		case 2:
			X= postitonX++;
			break;
		case 3:
			break;
		default:
			System.out.println(" erreur de direction :"+direction);
		}
		
		return X;
	}
	
	public int deplacementY(int direction,int postitonY) {
		//disposition nor sud ouest est
		//   0
		// 3   1
		//   2
		switch(direction){
		case 0:
			break;
		case 1:
			Y= postitonY++;
			break;
		case 2:
			break;
		case 3:
			Y= postitonY++;
			break;
		default:
			System.out.println(" erreur de direction :"+direction);
		}
		
		return Y;
	}
	
	public void pause(int millis) {
		try {
		    Thread.sleep(millis);
		} catch (InterruptedException ie) {
		    
		}
	}
	@Override
	public void run() {
		//pause(3000);
		System.out.println("run ? 2");
		
	}
}

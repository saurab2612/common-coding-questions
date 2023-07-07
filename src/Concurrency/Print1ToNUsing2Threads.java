package Concurrency;
//N = 20

class States {
	int state;
	States(int state){
		this.state = state;
	}
}

class PrintNumber extends Thread{
	
	int currentValue;
	int incr;
	int maxValue;
	int definedState;
	States state;
	PrintNumber(int maxValue,int currentValue, int incr, int definedState, States state){
		this.maxValue = maxValue;
		this.currentValue = currentValue;
		this.incr = incr;
		this.state = state;
		this.definedState = definedState;
	}

	@Override
	public void run(){
			while(maxValue>=currentValue) {
				synchronized (state) {
					while(state.state != definedState) {
						try {
							state.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(currentValue);
					currentValue+=incr;
					state.state = state.state==0?1:0;
					state.notify();
				}
			}
	}
	
}

public class Print1ToNUsing2Threads {

	public static void main(String[] args) {
		States state = new States(1);
		PrintNumber e = new PrintNumber(20, 2, 2, 0, state);
		PrintNumber o = new PrintNumber(20, 1, 2, 1, state);
		
		o.start();
		e.start();
	}

}

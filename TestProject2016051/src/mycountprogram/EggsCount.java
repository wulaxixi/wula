package mycountprogram;

public class EggsCount {
	
	public EggsCount() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ������С��ʮ������������ӣ���������һ�¹���<br>
	 * 1��1�����ó��������������ꣻ<br>
	 * 2��2�����ó���������ʣ1����<br>
	 * 3��3�����ó��������������ꣻ<br>
	 * 4��4�����ó���������ʣ1����<br>
	 * 5��5�����ó���������ʣ1����<br>
	 * 6��6�����ó���������ʣ3����<br>
	 * 7��7�����ó��������������ꣻ<br>
	 * 8��8�����ó���������ʣ1����<br>
	 * 8��8�����ó��������������ꡣ
	 * @param args
	 */
	public static void main(String[] args){
		for(int i=1;i<100000;i++){
			if((i-1)%2!=0)continue;
			if(i%3!=0)continue;
			if((i-1)%4!=0)continue;
			if((i-1)%5!=0)continue;
			if((i-3)%6!=0)continue;
			if(i%7!=0)continue;
			if((i-1)%8!=0)continue;
			if(i%9!=0)continue;
			System.err.println("����������"+i+";\n"+appendMessage(i));
		}
	}
	
	/**
	 * ƴ����ȡ������Ϣ
	 * @param i
	 * @return
	 */
	private static String appendMessage(int i){
		StringBuilder message = new StringBuilder();
		message.append("2������Ҫ"+(i-1)/2+"�Σ�");
		message.append("3������Ҫ"+(i)/3+"�Σ�");
		message.append("4������Ҫ"+(i-1)/4+"�Σ�");
		message.append("5������Ҫ"+(i-1)/5+"�Σ�");
		message.append("6������Ҫ"+(i-3)/6+"�Σ�");
		message.append("7������Ҫ"+(i)/7+"�Σ�");
		message.append("8������Ҫ"+(i-1)/8+"�Σ�");
		message.append("9������Ҫ"+(i)/9+"�Ρ�");
		return message.toString();
	}

}

package mycountprogram;

public class EggsCount {
	
	/**
<<<<<<< HEAD
	 * 计算存放小于十万个鸡蛋的篮子，可以满足一下规则：<br>
	 * 1个1个的拿出鸡蛋，整好拿完；<br>
	 * 2个2个的拿出鸡蛋，还剩1个；<br>
	 * 3个3个的拿出鸡蛋，整好拿完；<br>
	 * 4个4个的拿出鸡蛋，还剩1个；<br>
	 * 5个5个的拿出鸡蛋，还剩1个；<br>
	 * 6个6个的拿出鸡蛋，还剩3个；<br>
	 * 7个7个的拿出鸡蛋，整好拿完；<br>
	 * 8个8个的拿出鸡蛋，还剩1个；<br>
	 * 8个8个的拿出鸡蛋，整好拿完。
=======
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
>>>>>>> d4b1f762158692e3a8fec5e5fa07c4081ae5bd4a
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
<<<<<<< HEAD
			System.err.println("鸡蛋个数："+i+";\n"+appendMessage(i));
=======
			System.err.println("����������"+i+";\n"+appendMessage(i));
>>>>>>> d4b1f762158692e3a8fec5e5fa07c4081ae5bd4a
		}
	}
	
	/**
<<<<<<< HEAD
	 * 拼接拿取次数信息
=======
	 * ƴ����ȡ������Ϣ
>>>>>>> d4b1f762158692e3a8fec5e5fa07c4081ae5bd4a
	 * @param i
	 * @return
	 */
	private static String appendMessage(int i){
		StringBuilder message = new StringBuilder();
<<<<<<< HEAD
		message.append("2个的拿要"+(i-1)/2+"次；");
		message.append("3个的拿要"+(i)/3+"次；");
		message.append("4个的拿要"+(i-1)/4+"次；");
		message.append("5个的拿要"+(i-1)/5+"次；");
		message.append("6个的拿要"+(i-3)/6+"次；");
		message.append("7个的拿要"+(i)/7+"次；");
		message.append("8个的拿要"+(i-1)/8+"次；");
		message.append("9个的拿要"+(i)/9+"次。");
=======
		message.append("2������Ҫ"+(i-1)/2+"�Σ�");
		message.append("3������Ҫ"+(i)/3+"�Σ�");
		message.append("4������Ҫ"+(i-1)/4+"�Σ�");
		message.append("5������Ҫ"+(i-1)/5+"�Σ�");
		message.append("6������Ҫ"+(i-3)/6+"�Σ�");
		message.append("7������Ҫ"+(i)/7+"�Σ�");
		message.append("8������Ҫ"+(i-1)/8+"�Σ�");
		message.append("9������Ҫ"+(i)/9+"�Ρ�");
>>>>>>> d4b1f762158692e3a8fec5e5fa07c4081ae5bd4a
		return message.toString();
	}

}

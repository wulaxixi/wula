package mycountprogram;

public class EggsCount {
	
	/**
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
			System.err.println("鸡蛋个数："+i+";\n"+appendMessage(i));
		}
	}
	
	/**
	 * 拼接拿取次数信息
	 * @param i
	 * @return
	 */
	private static String appendMessage(int i){
		StringBuilder message = new StringBuilder();
		message.append("2个的拿要"+(i-1)/2+"次；");
		message.append("3个的拿要"+(i)/3+"次；");
		message.append("4个的拿要"+(i-1)/4+"次；");
		message.append("5个的拿要"+(i-1)/5+"次；");
		message.append("6个的拿要"+(i-3)/6+"次；");
		message.append("7个的拿要"+(i)/7+"次；");
		message.append("8个的拿要"+(i-1)/8+"次；");
		message.append("9个的拿要"+(i)/9+"次。");
		return message.toString();
	}

}

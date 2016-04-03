package questions;

public class IpIntoInt
{

	public static void main(String[] args)
	{
		String ip = "192.168.1.0";
		String[] ipArr = ip.split("\\.");
		int v4 = Integer.parseInt(ipArr[0]);
		int v3 = Integer.parseInt(ipArr[1]);
		int v2 = Integer.parseInt(ipArr[2]);
		int v1 = Integer.parseInt(ipArr[3]);
		int ipInt = (v4 << 24) | (v3 << 16) | (v2 << 8) | v1;
		System.out.println(ipInt);
		int ip1, ip2, ip3, ip4;
		StringBuffer buf = new StringBuffer("");
		ip1 = ipInt & (-1 >>> 24);
		ip2 = ipInt & ((-1 >>> 16) ^ (-1 >>> 24));
		ip2 = ip2 >> 8;
		ip3 = ipInt & ((-1 >>> 8) ^ (-1 >>> 16));
		ip3 = ip3 >> 16;
		ip4 = ipInt & ((-1) ^ (-1 >>> 8));
		ip4 = ip4 >>> 24;
		buf.append(ip4 + "." + ip3 + "." + ip2 + "." + ip1);
		System.out.println(buf.toString());

	}

}

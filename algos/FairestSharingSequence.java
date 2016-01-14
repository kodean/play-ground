/* 
/* 
 * The Fairest Sharing Sequence, also known as Thue-Morse sequence describes the order
 * in which two people should pick from a group of items so that they both get fairest
 * share.
 * 
 * Let's say A and B are going to pick from 4 items. If you say, the order should be 
 * A B A B, notice that A is always getting better item since he is picking first. 
 * (A B | A B): in first round, A picks best of top two items and same in second round
 * as well. So, they should pick in A B B A order.
 *
 * What if they have to pick from 8 items?
 * Using the same logic, the order should be A B B A | B A A B. Similarly for 16 items,
 * A B B A B A A B | B A A B A B B A
 *
 * There is a nifty way to print this sequence. If you want to print i'th element in
 * the sequence, count number of 1 bits in i and if it is even number, print 'A' and 
 * otherwise, print 'B'.
 *
 * Reference: https://www.youtube.com/watch?v=prh72BLNjIk
 * One of the comments on this video says that, to be fair, the sequence should have been
 * called the Thue-Morse-Morse-Thue sequence :)
 */

import java.util.Arrays;

public class FairestSharingSequence {
	public static void main(String[] args) {
		char[] fairestSharingSequence1 = getFairestSharingSequence(16);
		System.out.println(Arrays.toString(fairestSharingSequence1));
	}

	public static char[] getFairestSharingSequence(int n) {
		char[] fairestSharingSequence = new char[n];

		for (int i=0;i<n;i++) {
			fairestSharingSequence[i] = (count1Bits(i)%2==0)?'A':'B';
		}

		return fairestSharingSequence;
	}

	private static int count1Bits(int n) {
		int counter = 0;

		while (n!=0) {
			if ((n & 1) == 1) {
				counter++;
			}
			n = n >> 1;
		}

		return counter;
	}
}

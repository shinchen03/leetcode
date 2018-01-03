class Solution1 {
	// accepted only in range of long
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0;
        long num2 = 0;
        int i = 0;
        ListNode result = new ListNode(0);
        ListNode r = result;
        if (l1.val == l2.val && l1.val == 0 && l1.next == null) {
            return result;
        }
        while(l1 != null) {
            num1 += (long)Math.pow(10,i)*l1.val;
            i++;
            l1 = l1.next;
        }
        i = 0;
        while(l2 != null) {
            num2 += (long)Math.pow(10,i)*l2.val;
            i++;
            l2 = l2.next;
        }
        long temp = num1+num2;
        // System.out.println(temp);
        while(temp > 0) {
            long t = (long)temp%10;
            // System.out.println(t);
            result.next = new ListNode((int)t);
            result = result.next;
            temp /= 10;
        }
        return r.next;
    }
}



class Solution2 {
	// accepted
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return l1;
        }
        int s = 0;
        int v = 0;
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while(l1 != null && l2 != null) {
            v = l1.val + l2.val + s;
            if (v>=10) {
                s = 1;
                v -= 10;
            }
            else {
                s = 0;
            }
            temp.next = new ListNode(v);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 != null) { 
                l1 = new ListNode(0);
            }
            else if (l1 != null && l2 == null) {
                l2 = new ListNode(0);
            }
            if (l1 == null && l2 == null && s == 1) {
                temp.next = new ListNode(s);
                break;
            }
        }
        return result.next;
    }
}
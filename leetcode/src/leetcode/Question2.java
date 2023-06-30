package leetcode;

/**
 * @Author wushaoya
 * @date 2022-09-05
 * Time: 10:03
 */
public class Question2 {

    public ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        ListNode2 res = new ListNode2();
        if (l1 == null && l2 == null) {
            return res;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        int temp = 0;
        res = new ListNode2((l1.val + l2.val + temp) % 10);
        temp = (l1.val + l2.val + temp) / 10;
        dfsNode(l1.next, l2.next, res, temp);
        return res;
    }

    public void dfsNode(ListNode2 l1, ListNode2 l2, ListNode2 res, int temp) {
        if (l1 == null && l2 == null) {
            if (temp != 0) {
                res.next = new ListNode2(temp);
            }
            return;
        } else if (l1 == null && l2 != null) {
            res.next = new ListNode2((l2.val + temp) % 10);
            temp = (l2.val + temp) / 10;
            dfsNode(null, l2.next, res.next, temp);
        } else if (l1 != null && l2 == null) {
            res.next = new ListNode2((l1.val + temp) % 10);
            temp = (l1.val + temp) / 10;
            dfsNode(l1.next, null, res.next, temp);
        } else {
            res.next = new ListNode2((l1.val + l2.val + temp) % 10);
            temp = (l1.val + l2.val + temp) / 10;
            dfsNode(l1.next, l2.next, res.next, temp);
        }
    }


}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}

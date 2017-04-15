package linkedList;

public class PartitionList {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val=val;
		}
	}
	
	public ListNode apart(ListNode head,int x){
		ListNode lessPartHead=new ListNode(0);
		ListNode greaterPartHead=new ListNode(0);
		ListNode lessMark=lessPartHead;
		ListNode greaterMark=greaterPartHead;
		while(head!=null){
			if(head.val<x){
				lessMark.next=head;
				lessMark=lessMark.next;
				lessMark.next=null;
			}else{
				greaterMark.next=head;
				greaterMark=greaterMark.next;
				greaterMark.next=null;
			}
			head=head.next;
		}
		lessMark.next=greaterPartHead.next;
		return lessPartHead.next;
	}
}

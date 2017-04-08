package linkedList;

public class MergeTwoList {
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val=val;
		}
	}
	
	public ListNode merge(ListNode node1,ListNode node2){
		if(node1==null || node2==null)
			return node1==null?node2:node1;
		ListNode head=new ListNode(0);
		head.next=node1;
		ListNode track=head;
		while(node1!=null && node2!=null){
			if(node1.val>node2.val){
				ListNode newNode=node2.next;
				node2.next=node1;
				track.next=node2;
				node2=newNode;
			}else{
				node1=node1.next;
			}
			track=track.next;
		}
		
		if(node2!=null)
			track.next=node2;
		return head.next;
	}
}

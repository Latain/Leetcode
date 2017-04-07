package linkedList;

public class RemoveNthNode {
	private ListNode headNode;
	private ListNode position;
	
	public RemoveNthNode(int value){
		headNode=new ListNode(value);
		position=headNode;
	}
	
	public RemoveNthNode(int[] nums){
		for(int i=0;i<nums.length;i++){
			if(i==0){
				headNode=new ListNode(nums[i]);
				position=headNode;
			}else{
				ListNode node=new ListNode(nums[i]);
				position.next=node;
				position=position.next;
			}
		}
	}
	
	public ListNode getHead(){
		return headNode;
	}
	
	public void insert(int val){
		ListNode node=new ListNode(val);
		position.next=node;
		position=position.next;
	}
	
	public ListNode getNthNode(int index){
		ListNode node=headNode;
		for(int i=0;i<index;i++){
			if(i==index-1)
				return node.next;
			node=node.next;
		}
		return node;
	}
	
	private class ListNode{
		public int val;
		ListNode next;
		public ListNode(int val){
			this.val=val;
		}
		
		public String toString(){
			return String.valueOf(val);
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head,int n){
		ListNode copyNode=head;
		int length=1;
		while(copyNode.next!=null){
			length++;
			copyNode=copyNode.next;
		}
		
		if(n==length)
			return head.next;
		
		copyNode=head;
		if(n==1){
			for(int i=1;i<=length-1;i++){
				if(i==length-1)
					copyNode.next=null;
				copyNode=copyNode.next;
			}
			return head;
		}
		
		copyNode=head;
		ListNode node1=null;
		ListNode node2=null;
		for(int i=1;i<=length-n+2;i++){
			if(i==length-n)
				node1=copyNode;
			if(i==length-n+2)
				node2=copyNode;
			copyNode=copyNode.next;
		}
		node1.next=node2;
		return head;
	}
	
	public static void main(String[] args){
		RemoveNthNode linked=new RemoveNthNode(new int[]{1,5,6,4,7,8,3,2,6});
		ListNode head=linked.removeNthFromEnd(linked.getHead(),4);
		do{
			System.out.print(head);
			head=head.next;
		}while(head!=null);
	}
}

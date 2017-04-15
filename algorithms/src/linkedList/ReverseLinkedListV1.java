package linkedList;

public class ReverseLinkedListV1 {
	public class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
		}
	}
	
	private ListNode headNode;
	private ListNode markNode;
	
	public ReverseLinkedListV1(int[] nums){
		for(int i=0;i<nums.length;i++){
			ListNode newNode=new ListNode(nums[i]);
			if(i==0){
				headNode=markNode=newNode;
			}else{
				markNode.next=newNode;
				markNode=markNode.next;
			}
		}
	}
	
	public ListNode getHeadNode(){
		return headNode;
	}
	
	public ListNode reverseBetween(ListNode head,int m,int n){
		if(head==null)
			return null;
		if(m>n)
			return reverseBetween(head,n,m);
		ListNode addedHeadNode=new ListNode(0);
		addedHeadNode.next=head;
		ListNode preNode=addedHeadNode;
		
		int i=1;
		while(preNode.next!=null && i<m){
			i++;
			preNode=preNode.next;
		}
		
		if(i<m)
			return head;
		
		ListNode mNode=preNode.next;
		ListNode pos=mNode.next;
		while(pos!=null && i<n){
			ListNode next=pos.next;
			pos.next=preNode.next;
			preNode.next=pos;
			mNode.next=next;
			pos=next;
			i++;
		}
		return addedHeadNode.next;
	}
	
	public static void main(String[] args){
		int[] nums=new int[]{1,2,3,4,5,6,7,8,9};
		ReverseLinkedListV1 reverse=new ReverseLinkedListV1(nums);
		ListNode head=reverse.reverseBetween(reverse.getHeadNode(),2,3);
		while(head!=null){
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
}

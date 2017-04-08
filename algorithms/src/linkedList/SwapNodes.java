package linkedList;
import java.util.List;
import java.util.ArrayList;
public class SwapNodes {
	
	private class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
		}
		
		public String toString(){
			return String.valueOf(val);
		}
	}
	
	private ListNode headNode;
    private ListNode backNode;
    
	public SwapNodes(int[] nums){
		for(int i=0;i<nums.length;i++){
			if(i==0){
				headNode=new ListNode(nums[i]);
				backNode=headNode;
			}else{
				ListNode node=new ListNode(nums[i]);
				backNode.next=node;
				backNode=backNode.next;
			}
		}
	}
	
	public ListNode getHead(){
		return headNode;
	}
	
	public ListNode swapNodesInPairs(ListNode head){
		if(head==null || head.next==null)
			return head;
		int count=1;
		List<ListNode> list1=new ArrayList<ListNode>();
		List<ListNode> list2=new ArrayList<ListNode>();
		while(head!=null){
			if(count%2!=0)
				list1.add(head);
			if(count%2==0)
				list2.add(head);
			count++;
			head=head.next;
		}
		
		if(list1.size()>list2.size()){
			for(int i=0;i<list1.size();i++){
				if(i==list1.size()-1){
					list1.get(i-1).next=list1.get(i);
					list1.get(i).next=null;
				}else{
					list2.get(i).next=list1.get(i);
				}
			}
		}
		
		if(list1.size()==list2.size()){
			for(int i=0;i<list2.size();i++){
				if(i==list2.size()-1)
					list1.get(i).next=null;
				list2.get(i).next=list1.get(i);
			}
		}
		
		for(int i=0;i<=list2.size()-2;i++){
			list2.get(i).next.next=list2.get(i+1);
		}
		
		return list2.get(0);
	}
	
	public static void main(String[] args){
		int[] nums=new int[]{1,2,3,4,5};
		SwapNodes nodes=new SwapNodes(nums);
		ListNode newNode=nodes.getHead();
		newNode=nodes.swapNodesInPairs(newNode);
		while(newNode!=null){
			System.out.print(newNode);
			newNode=newNode.next;
		}
		
	}
}

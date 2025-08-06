import java.util.*;
class Solution {
    class Node{
        Node prev; 
        Node next;
        boolean removed;
    }
    public String solution(int n, int k, String[] cmd) {
        
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node();
        }
        for(int i = 0; i < n; i++){
            if(i > 0){
                nodes[i].prev = nodes[i - 1];
            }
            if(i < n - 1){
                nodes[i].next = nodes[i + 1];
            }
        }
        Node pointer = nodes[k];
        Stack<Node> temp = new Stack<>();
        int value = 0;
        for(String command : cmd){
            char c = command.charAt(0);
            switch(c){
                case 'D': value = Integer.parseInt(command.substring(2));
                          for(int i = 0; i < value; i++){
                              pointer = pointer.next;
                          }
                          break;
                case 'U': value = Integer.parseInt(command.substring(2));
                          for(int i = 0; i < value; i++){
                              pointer = pointer.prev;
                          }
                          break;
                case 'C': pointer.removed = true;
                          temp.push(pointer);
                          if(pointer.prev != null){
                              pointer.prev.next = pointer.next;
                          }
                          if(pointer.next != null){
                              pointer.next.prev = pointer.prev;
                          }
                          if(pointer.next != null){
                              pointer = pointer.next;
                          }
                          else{
                              pointer = pointer.prev;
                          }
                          break;
                case 'Z': Node restore = temp.pop();
                          restore.removed = false;
                          if(restore.next != null){
                              restore.next.prev = restore;
                          }
                          if(restore.prev != null){
                              restore.prev.next = restore;
                          }
                          break;
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            answer.append(nodes[i].removed? "X" : "O");
        }
        return answer.toString();
    }
}
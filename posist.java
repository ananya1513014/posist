/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public class posist{
    public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            
            int choice;
            
            List<NodeBO>nodeList = new ArrayList<>();
            
            int nodeNumber = 0;

            boolean bool=true;
            while(bool)
            {
                 System.out.println("Enter your choice\n1.Create Genesis Node\n2.Create Child Nodes of a node\n3.Create child node\n4.Encrypt or Decrypt\n5.Verify Owner\n6.Edit Value\n7.Transfer Ownership\n8.Longest Chain of Genesis\n9.Longest Chain of any node\n10.Merge\n11.Exit");
            
                choice = sc.nextInt();
            
            switch(choice)
            {
                case 1:
                    NodeBO myNode;
                    myNode=NodeDAO.createGenesisNode(nodeNumber);
                    nodeNumber++;
                    nodeList.add(myNode);
                    break;
                case 2:
                    System.out.println("Enter number of childs to be inserted");
                    int noOfNodes = sc.nextInt();
                    List<NodeBO> list = new ArrayList<>();
                    list = NodeDAO.createChildNodes(nodeNumber, noOfNodes);
                    nodeNumber=nodeNumber+noOfNodes;
                    nodeList.addAll(list);
                    break;
                case 3:
                    NodeBO myNode;
                    myNode=NodeDAO.createChildNode(nodeNumber);
                    nodeNumber++;
                    nodeList.add(myNode);
                    break;
                case 4:
                    NodeDAO.encrypt();
                    break;
                case 5:
                    NodeDAO.checkOwner();
                    break;
                case 6:
                    NodeDAO.editNode();
                    break;
                case 7:
                    NodeDAO.transferOwnership();
                    break;
                case 8:
                    int longestChainGN = NodeDAO.longestChainGNode(nodeList);
                    System.out.println(longestChainGN);
                    break;
                case 9:
                    int longestChain = NodeDAO.longestChainNode(nodeList);
                    System.out.println(longestChain);
                    break;
                case 10:
                    List<NodeBO> list = NodeDAO.mergeNodes();
                    nodeList = list;
                    break;
                case 11:
                    bool=false;
                default:
                    bool = true;
           }
            }
            
        }
}

class NodeBO implements Comparable
{
    Date timeStamp;
    String data;
    Integer nodeNumber;
    String nodeId;
    String referenceId;
    String childReferenceNodeId;
    String genesisReferenceNodeId;
    String hashValue;
    
    public NodeBO(Date timeStamp, String data, Integer nodeNumber, String nodeId,     String referenceId, String childReferenceNodeId, String genesisReferenceNodeId, String hashValue)
        {
            this.timeStamp=timeStamp;
            this.data=data;
            this.nodeNumber=nodeNumber;
            this.nodeId=nodeId;
            this.referenceId=referenceId;
            this.childReferenceNodeId=childReferenceNodeId;
            this.genesisReferenceNodeId=genesisReferenceNodeId;
            this.hashValue = hashValue;
        }
        
    @Override
    public String toString() 
        {
            return "Data = " + this.data;
        }    
        
    public int compareTo(NodeBO node)
        {
            return this.nodeNumber.compareTo(node.nodeNumber);
        }
        
    public String getTimeStamp()
        {
            return timeStamp;
        }
    public void setTimeStamp(timeStamp)
        {
           this.timeStamp=timeStamp;
        }

    public String getData()
        {
            return data;
        }
    public void setData(data)
        {
           this.data=data;
        }

    public String getNodeNumber()
        {
            return nodeNumber;
        }
    public void setNodeNumber(nodeNumber)
        {
           this.nodeNumber=nodeNumber;
        }

    public String getNodeId()
        {
            return nodeId;
        }
    public void setNodeId(nodeId)
        {
           this.nodeId=nodeId;
        }

    public String getReferenceId()
        {
            return referenceId;
        }
    public void setReferenceId(referenceId)
        {
           this.referenceId=referenceId;
        }

    public String getChildReferenceNodeId()
        {
            return childReferenceNodeId;
        }
    public void setChildReferenceNodeId(childReferenceNodeId)
        {
           this.childReferenceNodeId=childReferenceNodeId;
        }

    public String getGenesisReferenceNodeId()
        {
            return genesisReferenceNodeId;
        }
    public void setGenesisReferenceNodeId(genesisReferenceNodeId)
        {
           this.genesisReferenceNodeId=genesisReferenceNodeId;
        }

    public String getHashValue()
        {
            return hashValue;
        }
    public void setHashValue(hashValue)
        {
           this.hashValue=hashValue;
        }
}

class NodeDAO
{
    private static NodeBO createGenesisNode(int nodeNumber)
        {
            Scanner sc = new Scanner(System.in);
            
            Date date = new Date();

            System.out.println("Enter data");
            data = sc.nextLine();

            String nodeId = Integer.toString(nodeNumber);
            
            String referenceId = null;
            String childReferenceNodeId = null;
            String genesisReferenceNodeId = null;
            String hashValue = null;
        
            NodeBO nodeObj = new NodeBO(date, data, nodeNumber, nodeId, referenceId, childReferenceNodeId, genesisReferenceNodeId, hashValue);
            return nodeObj;
        }
        
     private static NodeBO createChildNode(int nodeNumber)
        {
            Scanner sc = new Scanner(System.in);
            
            Date date = new Date();

            System.out.println("Enter data");
            data = sc.nextLine();

            String nodeId = Integer.toString(nodeNumber);
            
            System.out.println("Enter Reference Id(Parent ID)");            
            String referenceId = sc.next();
            
            String childReferenceNodeId = null;
            
            System.out.println("Enter Reference Id(Parent ID)");            
            String genesisReferenceNodeId = sc.next();
            
            String hashValue = null;
        
            NodeBO nodeObj = new NodeBO(date, data, nodeNumber, nodeId, childReferenceNodeId, genesisReferenceNodeId, hashValue);
            
        }
        
    private static List<NodeBO> createChildNodes(int nodeNumber, int noOfNodes)
        {   
            List<NodeBO> list = new ArrayList<>();
            for(int i=0; i<noOfNodesl; i++)
                {
                    list.add(createChildNode(nodeNumber));
                    nodeNumber++;
                }
                
            for(int i=0; i<list.size(); i++)
                {
                    
                }
            return list;
        }
        
}

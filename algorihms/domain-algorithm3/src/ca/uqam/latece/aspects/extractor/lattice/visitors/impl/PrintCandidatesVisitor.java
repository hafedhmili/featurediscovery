package ca.uqam.latece.aspects.extractor.lattice.visitors.impl;

import java.util.HashMap;
import java.util.Set;

import ca.uqam.latece.aspects.extractor.lattice.model.LatticeNode;

/**
 * this visitor pretty prints the candidate nodes in a lattice. It starts from either the top (increasing intent/feature size,
 * and decreasing extent/occurrences) or the bottom (decreasing feature/intent size, increasing extent/occurrences number) and 
 * only prints the contents of the candidate nodes. This provides a hierarchical printout of candidate features that is easier to read
 * than a simple list.
 * 
 * The difference between this visitor and the pretty printer:
 * 1) we only print non-visited AND candidate nodes
 * 2) non-candidate nodes are skipped
 * 3) candidate nodes that are already visited: we print the Node_ID
 * 4) we override the preprocessChildren() method so that it does not print anything since there may be several
 * levels between two consecutive candidate nodes. We will increment the indents to gives us an idea, but we
 * won't print "ITS CHILDREN:================="
 *  
 * @author Hafedh
 *
 */
public class PrintCandidatesVisitor extends LatticePrettyPrinter {
	
	/**
	 * instance variable containing list of candidate nodes
	 */
	private HashMap<LatticeNode,FeatureDetectorVisitor.FeatureType> candidateNodes;
	
	public PrintCandidatesVisitor(HashMap<LatticeNode,FeatureDetectorVisitor.FeatureType> typedFeatureNodes){
		printer = JAVA_ELEMENT_PRINTER;
		candidateNodes = typedFeatureNodes;
	}
	/**
	 * the preprocessing of the children of the node prints the node type, and
	 *  computes the indent for printing the children
	 */
	public void preprocessChildren(LatticeNode node){
		String nodeIndent = getNodeIndents().get(node);
		// if this is the first node, use an empty string as an indent
		if (nodeIndent == null) {
			nodeIndent="";
			getNodeIndents().put(node, nodeIndent);
		}
		// if candidate node, print what kind of node it is
		if (candidateNodes.containsKey(node)){
			nodeIndent = nodeIndent.replaceAll("->", "  ");
			System.out.println(nodeIndent+ "FEATURE TYPE: "+ candidateNodes.get(node));			
		}
		String childrenIndent = nodeIndent + "\t->";
		for (LatticeNode child: node.getChildren()){
			getNodeIndents().put(child,childrenIndent);
		}
	}
	
	@Override
	/**
	 * if the node is a candidate node, print it. Otherwise, call process non-candidate nodes,
	 * which increases indents but prints nothing
	 */
	public void processNode(LatticeNode node) {
		
		// check if candidate node:
		if (candidateNodes.containsKey(node)){
			// then call inherited version
			super.processNode(node);
		}
	}
	
	@Override
	public void processVisitedNode(LatticeNode node) {
		// check if candidate node:
		if (candidateNodes.containsKey(node)){
			// then call inherited version
			super.processVisitedNode(node);
		}
	}

}

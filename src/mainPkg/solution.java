package mainPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
  
public class solution implements NumberRangeSummarizer{
	     
	String input;  
	String output;
	
	solution(String input) {
		this.input = input;
		
		if(input.isBlank() || input.isEmpty() || input == null) {
			output = "You have not entered any values.";
		}else if(input.matches(".*[a-zA-Z].*")){
			output = "You have entered an invalid input.";
		}else {
			this.output = summarizeCollection(collect(input));
		}
	}
	
	@Override
	public Collection<Integer> collect(String input) {
		// TODO Auto-generated method stub
		
		Collection <Integer> inputCollection = Arrays.stream(input.split(","))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		
		return inputCollection;
		
	}

	@Override
	public String summarizeCollection(Collection<Integer> input) {
		// TODO Auto-generated method stub
		
		String out = input.stream()
				.map( Integer::valueOf )
				.sorted()
				.distinct()
	            .collect(Collector.of(
	                    () -> {
	                        List<List<Integer>> innerList = new ArrayList<>();
	                        innerList.add(new ArrayList<>());
	                        return innerList;
	                    },
	                    (innerList, x) -> {
	                        List<Integer> segment = innerList.get(innerList.size() - 1);
	                        if (segment.size() == 0) {
	                        	segment.add(x);
	                        }else {
	                            int lastElement = segment.get(segment.size() - 1);
	                            if (lastElement == x - 1) {
	                            	segment.add(x);
	                            } else {
	                                List<Integer> segment2 = new ArrayList<>();
	                                segment2.add(x);
	                                innerList.add(segment2);
	                            }
	                        }
	                    },
	                    (left, right) -> {
	                        throw new IllegalArgumentException(""); //nothing to do in parallel
	                    },
	                    innerList -> {
	                        return innerList.stream()
	                                .map(segment -> {
	                                	if (segment.size() >= 3) {
	                                    	
	                                        return segment.get(0) + "-" + segment.get(segment.size() - 1);
		                                    
	                                    }else if (segment.size() == 2){//set must be more than 3
	                                    	return "" + segment.get(0) + ", " + segment.get(1);
	                                    }
	                                    	return "" + segment.get(0) ;
	                                    
	                                }).collect(Collectors.joining(", "));

	                    }));

		if(out.contains("-")) {
			return out;
		}else {
			return "All numbers are non-consecutive.";
		}
		
	}

}

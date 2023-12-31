package com.datastructures.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Meeting{
	int startTime;
	int endTime;
	int index;
	Meeting(int startTime, int endTime, int index){
		this.startTime = startTime;
		this.endTime = endTime;
		this.index = index;
	}
}

class MeetingComparator implements Comparator<Meeting>{

	@Override
	public int compare(Meeting o1, Meeting o2) {
		if ( o1.endTime < o2.endTime )	return -1;
		else if( o1.endTime > o2.endTime) return 1;
		else if (o1.index < o2.index)return -1;
		return 1;
	}
}
public class NMeetingsOneRoom {
	public static int maxMeetings(int start[], int end[], int n)
	{
		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		for(int i=0;i < n; i++ ) {
			meetings.add(new Meeting(start[i], end[i], i+1));
		}

		MeetingComparator meetingComparator = new MeetingComparator();
		Collections.sort(meetings,meetingComparator);
		ArrayList<Integer> order = new ArrayList<Integer>();

		int lastEndTime = meetings.get(0).endTime;
		order.add(meetings.get(0).index);
		int count =1;
		for(int i=1; i<n;i++) {
			if ( lastEndTime < meetings.get(i).startTime ) {
				lastEndTime = meetings.get(i).endTime;
				order.add(meetings.get(i).index);
				count++;
			}
		}
		return count;
	}

}

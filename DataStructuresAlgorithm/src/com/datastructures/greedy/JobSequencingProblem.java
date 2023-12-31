package com.datastructures.greedy;

import java.util.Arrays;

class Job {
	int id, profit, deadline;
	Job(int x, int y, int z){
		this.id = x;
		this.deadline = y;
		this.profit = z; 
	}
}

public class JobSequencingProblem {
	int[] JobScheduling(Job arr[], int n)
	{
		Arrays.sort(arr, (job1,job2)->job2.profit - job1.profit);

		int maxDeadLine = arr[0].deadline;
		for( Job job : arr ){
			maxDeadLine = Math.max( maxDeadLine, job.deadline);
		}

		int[] slots = new int[maxDeadLine];
		Arrays.fill(slots,-1);

		int maxProfit = 0;
		int maxJobs = 0;
		for(Job job : arr ){
			int jobId = job.id;
			int jobDeadLine = job.deadline;
			int jobProfit = job.profit;

			if ( slots[jobDeadLine-1] == -1 ){

				slots[jobDeadLine-1] = jobId;
				maxProfit = maxProfit + jobProfit;
				maxJobs++;

			}else{
				for( int i = jobDeadLine - 1; i>=0; i--){
					if ( slots[i] == -1) {
						slots[i] = jobId;
						maxJobs++;
						maxProfit = maxProfit + jobProfit;
						break;
					}
				}
			}
			if ( maxJobs == maxDeadLine ) break;
		}
		int[] ans  = {maxJobs,maxProfit};
		return ans;

	}

}

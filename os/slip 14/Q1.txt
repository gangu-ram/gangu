#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

#define MAX 100
#define NEWNODE (DIRENT *)malloc(sizeof(DIRENT))

typedef struct direntry
{
	char fname[20];
	int start,count;
	struct direntry *next;
}DIRENT;

int main()
{
	DIRENT *dirst=NULL,*dirend=NULL,*temp,*temp1;
	
	int bitvector[MAX];
	int i,j,n,ch;
	char fnm[20];
	
	for(i=0;i<MAX;i++)
	{
		bitvector[i]=1;
	}
	
	while(1)
	{
		printf("\n 1) Print Bit Vector");
		printf("\n 2) Create File");
		printf("\n 3) Print Files");
		printf("\n 4) Delete File");
		printf("\n 5) Exit");
		
		printf("\n Enter choice : ");
		scanf("%d",&ch);
				
		switch(ch)
		{
			case 1:	for(i=0;i<MAX;i++)
					{
						printf("%5d",bitvector[i]);
					}
			
					break;
					
			case 2:	if(dirst==NULL)
      				{
						dirst=dirend=NEWNODE;
					}
      				else
      				{
						temp = NEWNODE;
						dirend->next=temp;
						dirend=temp;
      				}
      				
      				dirend->next=NULL;
      
	  				printf("\n Enter Filename : ");
      				scanf("%s",dirend->fname);
      
	  				printf("\nEnter The Number of Blocks To Allocate : ");
      				scanf("%d",&n);
      				
      				for(i=0;i<100;i++)
      				{
       					if(bitvector[i]==1) 
       					{
							for(j=i;j<i+n;j++) 
							{
	 							if(bitvector[j]==0)
	  								break;
							}

							if(j==i+n) 
							{
	 							dirend->start=i;
	 							dirend->count=n;
	 							
	 							for(j=i;j<i+n;j++)
	 							{
									bitvector[j]=0;
								}
								
	 							break;
							}
       					}
      				}
      				
      				break;

			case 3:	printf("\n File Details");
					printf("\n File Name \t Start \t Size");
					for(temp=dirst;temp!=NULL;temp=temp->next)
					{
						printf("\n %s \t %d \t %d",temp->fname,temp->start,temp->count);
					}
					break;
			
			case 4:	printf("\n Enter File Name : ");
					scanf("%s",fnm);
					
					temp1 = dirst;
					
					for(temp=dirst;temp!=NULL;temp=temp->next)
					{
						if(strcmp(temp->fname,fnm)==0)
						{
							break;	
						}
						
						temp1 = temp;
					}
					
					if(temp!=NULL)
					{
						for(i=temp->start;i<temp->start+temp->count;i++)
						{
							bitvector[i] = 1;
						}
						
						if(temp==dirst)
						{
							dirst=dirst->next;
						}
						else
						{
							temp1->next = temp->next;	
						}
						
						free(temp);
					}
					else
					{
						printf("\n File not found");
					}
					
					break;
			
			case 5:	exit(0);
			
			default: printf("\n Invalid Choice");
		}
	}
	
	return 0;
}

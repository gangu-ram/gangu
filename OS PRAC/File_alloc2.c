#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<string.h>

#define MAX 100
#define NEWNODE (DIRENT *)malloc(sizeof(DIRENT))
#define NEWBLK (BLK *)malloc(sizeof(BLK))

typedef struct blknode
{
  	int bno;
  	struct blknode *next;
}BLK;
BLK *curr,*prev;

typedef struct direntry
{
	char fname[20];
	int start,end;
	BLK *blist;
	struct direntry *next;
}DIRENT;

int main()
{
	DIRENT *dirst=NULL,*dirend=NULL,*temp,*t1,*t2;
	
	int bitvector[MAX];
	int i,j,n,ch;
	char fnm[20];
	
	for(i=0;i<MAX;i++)
	{
		bitvector[i]=1;
	}
	
	bitvector[0]=0;
	bitvector[3]=0;
	bitvector[5]=0;
	bitvector[9]=0;
	bitvector[10]=0;
	
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
      				dirend->blist=NULL;
      
	  				printf("\n Enter Filename : ");
      				scanf("%s",dirend->fname);
      
	  				printf("\nEnter The Number of Blocks To Allocate : ");
      				scanf("%d",&n);
      				
      				for(i=0;n>0;i++)
				    {
				     	if(bitvector[i]==1) 
				     	{
				       		curr=NEWBLK;
				       		curr->bno=i; 
							curr->next=NULL;
				       
					   		if(dirend->blist==NULL)
				       		{ 
							   	dirend->start=i;
					 			dirend->blist=curr;
					 			prev=curr;
				       		}
				       		else
				       		{ 
							   	prev->next=curr;
					 			prev=curr;
				       		}
				       		
							bitvector[i]=0; 
				       		n--;
				     	}
				    }
				    
				    dirend->end=i;
      				
      				break;

			case 3:	printf("\n File Details");
					printf("\n File Name \t Start \t End \t List");
					for(temp=dirst;temp!=NULL;temp=temp->next)
					{
						printf("\n %s \t %d \t %d",temp->fname,temp->start,temp->end);
						printf(" (");
				     	for(curr=temp->blist;curr!=NULL;curr=curr->next)
				     	{
							printf("%3d",curr->bno);
						}
				     	printf(")");
					}
					break;
			
			case 4:	printf("\nEnter a Filename : ");
				    scanf("%s",fnm);
				    
				    for(t1=dirst;t1!=NULL;t1=t1->next)
				    {
				      	if(strcmp(t1->fname,fnm)==0)
				      	{
							break;
						}
						
				      	t2=t1;
				    }
				    
				    if(t1!=NULL)
				    {
				      	for(curr=t1->blist; curr!=NULL;)
				       	{ 
						   	bitvector[curr->bno]=1;
					 		prev=curr;
					 		curr=curr->next;
					 		free(prev);
				       	}
				
				      	if(t1==dirst)
				      	{
							dirst=dirst->next;
						}
				      	else
				      	{
							t2->next=t1->next;
						}
				
				      	if(dirst==NULL)
				      	{
							dirend=NULL;
						}
						
				      	free(t1);
				    }
				    else
				    {
					   	printf("File not found..");
				    }
				    
				    break;
			
			case 5:	exit(0);
			
			default: printf("\n Invalid Choice");
		}
	}
	
	return 0;
}

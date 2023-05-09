#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<string.h>

#define MAX 100
#define NEWNODE (DIRENT *)malloc(sizeof(DIRENT))

typedef struct direntry
{
	char fname[20];
	int bno,blist[20],n;
	struct direntry *next;
}DIRENT;

int main()
{
	DIRENT *dirst=NULL,*dirend=NULL,*temp,*t1,*t2;
	
	int bitvector[MAX];
	int i,j,n,ch,flag;
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
      				      
	  				printf("\n Enter Filename : ");
      				scanf("%s",dirend->fname);
      
	  				printf("\nEnter The Number of Blocks To Allocate : ");
      				scanf("%d",&n);
      				
      				dirend->n=n;
      				flag=0;
      				j=0;
      				
      				for(i=0;n>0;i++)
				    {
				     	if(bitvector[i]==1) 
				     	{
				       		if(flag==0)
	       					{
								dirend->bno=i;
								flag=1;
	       					}
			       			else
			       			{
								dirend->blist[j]=i; 
								j++;
			       			}
				       		
							bitvector[i]=0; 
				       		n--;
				     	}
				    }
      				
      				break;

			case 3:	printf("\n File Details");
					printf("\n File Name \t IndexBlockNo \t Block List");
					for(temp=dirst;temp!=NULL;temp=temp->next)
					{
						printf("\n %s \t %d",temp->fname,temp->bno);
						printf(" (");
				     	for(j=0;j<temp->n-1;j++)
				     	{
							printf("%3d",temp->blist[j]);
						}
				     	printf(")");
					}
					break;
			
			case 4:	printf("\n Enter a Filename : ");
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
				      	for(i=0;i<t1->n-1;i++)
				      	{
							bitvector[t1->blist[i]]=1;
						}
						
	      				bitvector[t1->bno]=1;
				
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

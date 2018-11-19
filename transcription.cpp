#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
#pragma warning(disable : 4996)

int str_length(char *str) {
	int i = 0;
	while (str[i]) {
		i++;
	}

	return i;
}

int where_start(char *a, int n) //�����ڵ� 
{
	for (int i = 0; i<98; i++) {
		if (*(a + i) == 'A' && *(a + (i + 1)) == 'U' && *(a + (i + 2)) == 'G')
			return i;
	}
	return -1;
}

int where_end(char *a, int n) //�����ڵ� 
{
	for (int i = where_start(a, n); i<98; i += 3) {
		if (*(a + i) == 'U' && *(a + (i + 1)) == 'A' && *(a + (i + 2)) == 'A')
			return i;
		if (*(a + i) == 'U' && *(a + (i + 1)) == 'A' && *(a + (i + 2)) == 'G')
			return i;
		if (*(a + i) == 'U' && *(a + (i + 1)) == 'G' && *(a + (i + 2)) == 'A')
			return i;
	}
	return -1;
}
int only_AGCT(char *a, int n) //AGTC �̿��� ��� ���ڿ� ���缺 �Ǵ� 
{
	for (int i = 0; i<n; i++) {
		if (*(a + i) == 'A' || *(a + i) == 'T' || *(a + i) == 'G' || *(a + i) == 'C');
		else return 0;
	}
	return 1;
}

void transcription(char *a, char *b, int n) //DNA�κ��� ����Ǵ� mRNA 
{
	for (int i = 0; i<n; i++) {
		switch (*(a + i)) {
		case 'A': *(b + i) = 'U';
			break;
		case 'G': *(b + i) = 'C';
			break;
		case 'C': *(b + i) = 'G';
			break;
		case 'T': *(b + i) = 'A';
			break;
		}
	}
}

void genetic_code(char *a, int n) //������ȣ �ص�ǥ 
{
	int i, s, d;
	s = where_start(a, n);
	d = where_end(a, n);
	for (i = s; i <= d; i += 3) {
		switch (*(a + i)) {
		case 'A': {
			switch (*(a + (i + 1))) {
			case 'A': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("���̽�");
					printf("-");
					break;
				}
				case 'G': {
					printf("���̽�");
					printf("-");
					break;
				}
				case 'C': {
					printf("�ƽ��Ķ��");
					printf("-");
					break;
				}
				case 'U': {
					printf("�ƽ��Ķ��");
					printf("-");
					break;
				}
				}
				break;
			} //AA* �Ϸ� 
			case 'G': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("�Ƹ�����");
					printf("-");
					break;
				}
				case 'G': {
					printf("�Ƹ�����");
					printf("-");
					break;
				}
				case 'C': {
					printf("����");
					printf("-");
					break;
				}
				case 'U': {
					printf("����");
					printf("-");
					break;
				}
				}
				break;
			} //AG* �Ϸ� 
			case 'C': {
				printf("Ʈ������");
				printf("-");
				break;
			}

			case 'U': {
				switch (*(a + (i + 2))) {
				case 'G': {
					printf("�޽��̿���");
					printf("-");
					break;
				}
				default: {
					printf("���̼ҷ���");
					printf("-");
					break;
				}
				}
				break;
			} //AU* �Ϸ� 
			}
			break;
		} //A���ۿ��� �Ϸ�

		case 'G': {
			switch (*(a + (i + 1))) {
			case 'A': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("�۷�Ž��");
					printf("-");
					break;
				}
				case 'G': {
					printf("�۷�Ž��");
					printf("-");
					break;
				}
				case 'U': {
					printf("�ƽ���Ʈ��");
					printf("-");
					break;
				}
				case 'C': {
					printf("�ƽ���Ʈ��");
					printf("-");
					break;
				}
				}
				break;
			} //GA* �� 
			case 'C': {
				printf("�˶��");
				printf("-");
				break;
			} //GC* �� 
			case 'U': {
				printf("�߸�");
				printf("-");
				break;
			} //GU* ��
			case 'G': {
				printf("�۶��̽�");
				printf("-");
				break;
			} //GG* ��
			}
			break;
		} //G���ۿ��� �� 

		case 'C': {
			switch (*(a + (i + 1))) {
			case 'A': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("�۷�Ÿ��");
					printf("-");
					break;
				}
				case 'G': {
					printf("�۷�Ÿ��");
					printf("-");
					break;
				}
				case 'C': {
					printf("����Ƽ��");
					printf("-");
					break;
				}
				case 'U': {
					printf("����Ƽ��");
					printf("-");
					break;
				}
				}
				break;
			} //CA* �Ϸ� 
			case 'G': {
				printf("�Ƹ�����");
				printf("-");
				break;
			} //CG* �Ϸ� 
			case 'C': {
				printf("���Ѹ�");
				printf("-");
				break;
			}	//CC* �Ϸ� 
			case 'U': {
				printf("����");
				printf("-");
				break;
			} //CU* �Ϸ� 
			}
			break;
		} //C���ۿ��� �Ϸ�

		case 'U': {
			switch (*(a + (i + 1))) {
			case 'A': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("(����)");
					break;
				}
				case 'G': {
					printf("(����)");
					break;
				}
				case 'C': {
					printf("Ÿ�̷ν�");
					printf("-");
					break;
				}
				case 'U': {
					printf("Ÿ�̷ν�");
					printf("-");
					break;
				}
				}
				break;
			} //UA* �Ϸ� 
			case 'G': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("(����)");
					break;
				}
				case 'G': {
					printf("Ʈ������");
					printf("-");
					break;
				}
				case 'C': {
					printf("�ý�����");
					printf("-");
					break;
				}
				case 'U': {
					printf("�ý�����");
					printf("-");
					break;
				}
				}
				break;
			} //UG* �Ϸ� 
			case 'C': {
				printf("����");
				printf("-");
				break;
			} //UC* �Ϸ� 

			case 'U': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("����");
					printf("-");
					break;
				}
				case 'G': {
					printf("����");
					printf("-");
					break;
				}
				case 'C': {
					printf("��Ҿ˶��");
					printf("-");
					break;
				}
				case 'U': {
					printf("��Ҿ˶��");
					printf("-");
					break;
				}
				}
				break;
			} //UU* �Ϸ� 
			}
			break;
		} //U���ۿ��� �Ϸ�
		}
	}

}

int main() {
	char mRNA[100], DNA[100];
	int n, i = 0;
	// printf("%s \n", DNA);
	do {
	back:
		system("cls");
		printf("�����Ǵ� DNA�� ���� ������ �Է��Ͻÿ�. <A,T,G,C> \n ���� DNA : 3'-");
		scanf("%s 5'", DNA);
		n = str_length(DNA);
	} while (only_AGCT(DNA, n) != 1); //�Է� �� ���� ������ ��Ȯ������ ���� Ȯ��
	transcription(DNA, mRNA, n);
	if (where_start(mRNA, n) == -1)
		goto back;
	if (where_end(mRNA, n) == -1)
		goto back;
	printf("���� mRNA : 5'-");
	mRNA[n] = '\0';
	printf("%s \n", mRNA);
	printf("������Ÿ�̵�� ������ ����. \n ������Ÿ�̵� : ");
	genetic_code(mRNA, n);
	printf("\n");
}

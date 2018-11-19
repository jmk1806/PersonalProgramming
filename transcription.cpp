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

int where_start(char *a, int n) //개시코돈 
{
	for (int i = 0; i<98; i++) {
		if (*(a + i) == 'A' && *(a + (i + 1)) == 'U' && *(a + (i + 2)) == 'G')
			return i;
	}
	return -1;
}

int where_end(char *a, int n) //종결코돈 
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
int only_AGCT(char *a, int n) //AGTC 이외의 모든 문자열 존재성 판단 
{
	for (int i = 0; i<n; i++) {
		if (*(a + i) == 'A' || *(a + i) == 'T' || *(a + i) == 'G' || *(a + i) == 'C');
		else return 0;
	}
	return 1;
}

void transcription(char *a, char *b, int n) //DNA로부터 전사되는 mRNA 
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

void genetic_code(char *a, int n) //유전암호 해독표 
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
					printf("라이신");
					printf("-");
					break;
				}
				case 'G': {
					printf("라이신");
					printf("-");
					break;
				}
				case 'C': {
					printf("아스파라긴");
					printf("-");
					break;
				}
				case 'U': {
					printf("아스파라긴");
					printf("-");
					break;
				}
				}
				break;
			} //AA* 완료 
			case 'G': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("아르지닌");
					printf("-");
					break;
				}
				case 'G': {
					printf("아르지닌");
					printf("-");
					break;
				}
				case 'C': {
					printf("세린");
					printf("-");
					break;
				}
				case 'U': {
					printf("세린");
					printf("-");
					break;
				}
				}
				break;
			} //AG* 완료 
			case 'C': {
				printf("트레오닌");
				printf("-");
				break;
			}

			case 'U': {
				switch (*(a + (i + 2))) {
				case 'G': {
					printf("메싸이오닌");
					printf("-");
					break;
				}
				default: {
					printf("아이소류신");
					printf("-");
					break;
				}
				}
				break;
			} //AU* 완료 
			}
			break;
		} //A시작염기 완료

		case 'G': {
			switch (*(a + (i + 1))) {
			case 'A': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("글루탐산");
					printf("-");
					break;
				}
				case 'G': {
					printf("글루탐산");
					printf("-");
					break;
				}
				case 'U': {
					printf("아스파트산");
					printf("-");
					break;
				}
				case 'C': {
					printf("아스파트산");
					printf("-");
					break;
				}
				}
				break;
			} //GA* 끝 
			case 'C': {
				printf("알라닌");
				printf("-");
				break;
			} //GC* 끝 
			case 'U': {
				printf("발린");
				printf("-");
				break;
			} //GU* 끝
			case 'G': {
				printf("글라이신");
				printf("-");
				break;
			} //GG* 끝
			}
			break;
		} //G시작염기 끝 

		case 'C': {
			switch (*(a + (i + 1))) {
			case 'A': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("글루타민");
					printf("-");
					break;
				}
				case 'G': {
					printf("글루타민");
					printf("-");
					break;
				}
				case 'C': {
					printf("히스티딘");
					printf("-");
					break;
				}
				case 'U': {
					printf("히스티딘");
					printf("-");
					break;
				}
				}
				break;
			} //CA* 완료 
			case 'G': {
				printf("아르지닌");
				printf("-");
				break;
			} //CG* 완료 
			case 'C': {
				printf("프롤린");
				printf("-");
				break;
			}	//CC* 완료 
			case 'U': {
				printf("류신");
				printf("-");
				break;
			} //CU* 완료 
			}
			break;
		} //C시작염기 완료

		case 'U': {
			switch (*(a + (i + 1))) {
			case 'A': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("(종결)");
					break;
				}
				case 'G': {
					printf("(종결)");
					break;
				}
				case 'C': {
					printf("타이로신");
					printf("-");
					break;
				}
				case 'U': {
					printf("타이로신");
					printf("-");
					break;
				}
				}
				break;
			} //UA* 완료 
			case 'G': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("(종결)");
					break;
				}
				case 'G': {
					printf("트립토판");
					printf("-");
					break;
				}
				case 'C': {
					printf("시스테인");
					printf("-");
					break;
				}
				case 'U': {
					printf("시스테인");
					printf("-");
					break;
				}
				}
				break;
			} //UG* 완료 
			case 'C': {
				printf("세린");
				printf("-");
				break;
			} //UC* 완료 

			case 'U': {
				switch (*(a + (i + 2))) {
				case 'A': {
					printf("류신");
					printf("-");
					break;
				}
				case 'G': {
					printf("류신");
					printf("-");
					break;
				}
				case 'C': {
					printf("페닐알라닌");
					printf("-");
					break;
				}
				case 'U': {
					printf("페닐알라닌");
					printf("-");
					break;
				}
				}
				break;
			} //UU* 완료 
			}
			break;
		} //U시작염기 완료
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
		printf("번역되는 DNA의 염기 서열을 입력하시오. <A,T,G,C> \n 번역 DNA : 3'-");
		scanf("%s 5'", DNA);
		n = str_length(DNA);
	} while (only_AGCT(DNA, n) != 1); //입력 및 염기 서열이 정확한지에 대한 확인
	transcription(DNA, mRNA, n);
	if (where_start(mRNA, n) == -1)
		goto back;
	if (where_end(mRNA, n) == -1)
		goto back;
	printf("전사 mRNA : 5'-");
	mRNA[n] = '\0';
	printf("%s \n", mRNA);
	printf("폴리펩타이드는 다음과 같다. \n 폴리펩타이드 : ");
	genetic_code(mRNA, n);
	printf("\n");
}

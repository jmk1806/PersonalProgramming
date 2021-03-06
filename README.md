# PersonalProgramming
DNA의 전사(transcription), 번역(translation) 과정을 시뮬레이션하는 소규모 개인 프로젝트입니다.

자세한 배경 지식은 Wiki에 명시해놓았으니, 참조부탁드립니다.
https://github.com/jmk1806/PersonalProgramming/wiki

프로그램의 진행 과정
input : DNA(트리플렛 코드), 혹은 mRNA(코돈)

1. DNA가 입력되는 경우
DNA->mRNA->(tRNA)->단백질, 이 과정을 시뮬레이션하게 됩니다. tRNA는 명시되지는 않지만, 단백질을 합성하는데 쓰이는 최종 암호로써, 
mRNA가 baseOnly를 접근할 때 tRNA(안티 코돈)를 생성하며 단백질이 합성하도록 하였습니다.
DNA를 입력할 때에는 반드시 5'-부터 입력해주셔야합니다. 즉, 만약 문제에 3'-으로 시작하는 트리플렛 코드가 제공된다면 그 암호들을 역순으로
입력해주시면 된다는 것입니다.

2. mRNA가 입력되는 경우
1의 과정에서 DNA만 빠지고, 나머지 부분은 동일합니다.

3. 주의 사항 : 간혹 특정 규칙의 암호에 대하여 Exception을 반환하는 경우가 있습니다. 예외 처리가 완성되지 않은 코드이므로, 실험 등의 목적으로
너무 이상한 암호를 넣는 것을 지양해야 합니다.

개발 환경과 프로그래밍 규약 또한 Wiki에 명시되어 있으니, 만약 이와 관련하여 확인이 필요하다면 Wiki 확인 부탁드립니다.
https://github.com/jmk1806/PersonalProgramming/wiki

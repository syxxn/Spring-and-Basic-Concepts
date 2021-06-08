# Git-flow와 Github-flow



Git-flow와 Github-flow는 대표적인 브랜칭 전략으로서, Gitbhub-flow도 많이 사용한다고 한다.



### Git-flow

Git-flow는 브랜치를 크게 4가지(main, feature, release, hotfix)로 나누어 개발하는 전략이다.

가장 중심이 되는 브랜치는 master(main)와 develop이며, merge된 feature, release, hotfix는 삭제하는 것이 일반적이다.

Git-flow는 주기적으로 배포를 해야 하는 프로젝트에는 적합하지만, 브랜치가 많아 복잡하며, 어떤 프로젝트에 따라서는 몇몇 브랜치가 애매한 포지션을 가지게 될 수도 있다.



#### main

master와 develop, 이 두 종류의 브랜치를 보통 메인 브랜치로 사용한다. 

+ master : 배포 가능한 상태만을 관리하는 브랜치이다.
+ develop : 다음에 배포할 것을 개발하는 브랜치. 통합 브랜치 역할

#### support

develop에서 분기하며, 기능을 개발하는 브랜치이다.

+ feature : 기능을 다 완성할 때까지 유지하고, 다 완성되면 develop 브랜치로 merge한다.

  feture 브랜치는 보통 개발자 저장소에만 있는 브랜치이며, origin에는 push하지 않는다.

#### release

develop에서 생성하는 브랜치로, 배포를 위한 최종적인 버그 수정 등의 개발을 수행한다.

버그 수정 사항은 develop에도 적용해 주어야 하며, 배포 가능한 상태가 되면 master로 병합시키고, 출시된 master 브랜치에 버전 태그를 추가한다.

#### hotfix

배포한 버전에서 긴급하게 수정을 해야 할 필요가 있을 경우, master 브랜치에서 분기하는 브랜치이다.

release와 마찬가지로, 수정 사항을 develop에도 적용시켜야 한다.



### Github-flow

Github에서 사용하기엔 Git-flow가 복잡하다고 해서 나온 브랜칭 전략이다. master 브랜치에 대한 role만 정확하다면 다른 브랜치들에 대해서는 관여하지 않는다. pull request 기능을 사용하도록 권장한다.



#### 사용법

1. master는 언제든 배포가 가능하다
   + master로 merge하기 전에는 충분히 테스트를 해야 하는데, 이 테스트는 로컬에서 하는 것이 아니라 origin으로 push하여 jenkins와 같은 ci 툴을 사용해서 하는 것이다.
2. master에서 새로운 일을 시작하기 위해 브랜치를 만든다면, 이름을 명확히 작성해야 한다.
   + feature나 develop이 존재하지 않기 때문에 어떤 일을 하고 있는지 브랜치 명에 자세하게 작성해야 한다. 또한 커밋 메세지를 명확하게 해야 한다.
3. 원격지(origin) 브랜치로 수시로 push해야 한다.
   + 자신이 하고 있는 일을 origin에 올려 다른 사람들도 확인할 수 있도록 한다.
4. 피드백이나 도움이 필요할 때, 그리고 merge 준비가 완료되었을 때는 pull request를 생성한다.
   + pull request는 코드 리뷰를 도와주는 시스템이다.
5. 기능에 대한 리뷰와 논의가 끝난 후 master로 merge한다.
   + 물론 ci도 통과해야 한다.

6. master로 merge되고 push 되었을 때는 즉시 배포되어야 한다. 
   + master로 merge가 일어나면 자동으로 배포가 되도록 설정해 놓는다.(지속적 배포 cd)


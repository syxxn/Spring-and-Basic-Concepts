# Git-flow와 Github-flow



Git-flow와 Github-flow는 대표적인 브랜칭 전략으로서, 실무에서는 Gitbhub-flow를 더 많이 사용한다고 한다.



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


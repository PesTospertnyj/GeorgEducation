create sequence hibernate_sequence;

create table person
(
  id   bigint not null,
  name varchar(255),
  constraint person_pkey
    primary key (id),
  constraint uk_is4vd0f6kw9sw4dxyie5cy9fa
    unique (name)
);

create table skill
(
  id   bigint not null,
  name varchar(255),
  constraint skill_pkey
    primary key (id)
);

create table ranking
(
  id          bigint not null,
  ranking     integer,
  observer_id bigint,
  skill_id    bigint,
  subject_id  bigint,
  constraint ranking_pkey
    primary key (id),
  constraint fkive1infoo3bhngyyh21wpjowd
    foreign key (observer_id) references person,
  constraint fk4k8xflg6vgtx54xdi3l86oxv3
    foreign key (skill_id) references skill,
  constraint fkco74nphdiivkvnlujo211y2s9
    foreign key (subject_id) references person,
    constraint uk_ranking unique (observer_id, skill_id, subject_id)
);


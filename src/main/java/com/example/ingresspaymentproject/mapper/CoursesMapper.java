package com.example.ingresspaymentproject.mapper;

@Mapper
@Component
public class CoursesMapper {
  public CoursesEntity fromDto(StudentDto studentDto){
    CoursesEntity entity = CoursesEntity.builder()
            .courseName(studentDto.get)
            .build();
    return entity;
}

    public List<CoursesEntity> fromDtoList(List<StudentDto> studentDtos){
        StudentMapper mapper = new StudentMapper();
       return studentDtos.stream().map(n->mapper.fromDto(n)).collect(Collectors.toList());

    }
    public CoursesDto toDto(CoursesEntity courseEntity){
        CoursesDto course = CoursesDto.builder()
                .email(studentEntity.getEmail())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .phone(studentEntity.getPhone())
                .id(studentEntity.getId())
                .build();
        return student;
    }

    public List<CoursesDto> toDtoList(List<CoursesEntity> coursesEntity){
        CoursesMapper mapper = new CoursesMapper();
        return coursesEntity.stream().map(n->mapper.toDto(n)).collect(Collectors.toList());

    }
}

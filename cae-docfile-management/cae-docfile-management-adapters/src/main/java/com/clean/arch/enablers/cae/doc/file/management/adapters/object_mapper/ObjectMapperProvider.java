package com.clean.arch.enablers.cae.doc.file.management.adapters.object_mapper;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.*;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectMapperProvider {

    public static final ObjectMapper MAPPER;

    static {
         MAPPER = new ObjectMapper();
         MAPPER
                 .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                 .registerModule(new DomainModule())
                 .registerModule(new ResponsibleTeamModule())
                 .registerModule(new ContactModule())
                 .registerModule(new TeamMemberModule())
                 .registerModule(new VersionModule())
                 .registerModule(new UseCaseInfoModule())
                 .registerModule(new UseCaseIOInfoModule())
                 .registerModule(new UseCaseIOFieldInfoModule());
         MAPPER.findAndRegisterModules();
         MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static class DomainDeserializer extends StdDeserializer<Domain>{

        protected DomainDeserializer() {
            super(Domain.class);
        }

        @Override
        public Domain deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(DomainImplementation.class);
        }
    }

    public static class DomainModule extends SimpleModule{

        public DomainModule(){
            addDeserializer(Domain.class, new DomainDeserializer());
        }
    }

    public static class ResponsibleTeamDeserializer extends StdDeserializer<ResponsibleTeam>{

        protected ResponsibleTeamDeserializer() {
            super(ResponsibleTeam.class);
        }

        @Override
        public ResponsibleTeam deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(ResponsibleTeamImplementation.class);
        }
    }

    public static class ResponsibleTeamModule extends SimpleModule{

        public ResponsibleTeamModule(){
            addDeserializer(ResponsibleTeam.class, new ResponsibleTeamDeserializer());
        }
    }

    public static class ContactDeserializer extends StdDeserializer<Contact>{

        protected ContactDeserializer() {
            super(Contact.class);
        }

        @Override
        public Contact deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(ContactImplementation.class);
        }
    }

    public static class ContactModule extends SimpleModule{

        public ContactModule(){
            addDeserializer(Contact.class, new ContactDeserializer());
        }
    }

    public static class TeamMemberDeserializer extends StdDeserializer<TeamMember>{

        protected TeamMemberDeserializer() {
            super(TeamMember.class);
        }

        @Override
        public TeamMember deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(TeamMemberImplementation.class);
        }
    }

    public static class TeamMemberModule extends SimpleModule{

        public TeamMemberModule(){
            addDeserializer(TeamMember.class, new TeamMemberDeserializer());
        }
    }

    public static class VersionDeserializer extends StdDeserializer<Version>{

        protected VersionDeserializer() {
            super(Version.class);
        }

        @Override
        public Version deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(VersionImplementation.class);
        }
    }

    public static class VersionModule extends SimpleModule{

        public VersionModule(){
            addDeserializer(Version.class, new VersionDeserializer());
        }
    }

    public static class UseCaseInfoDeserializer extends StdDeserializer<UseCaseInfo>{

        protected UseCaseInfoDeserializer() {
            super(UseCaseInfo.class);
        }

        @Override
        public UseCaseInfo deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(UseCaseInfoImplementation.class);
        }
    }

    public static class UseCaseInfoModule extends SimpleModule{

        public UseCaseInfoModule(){
            addDeserializer(UseCaseInfo.class, new UseCaseInfoDeserializer());
        }
    }

    public static class UseCaseIOInfoDeserializer extends StdDeserializer<UseCaseIOInfo>{

        protected UseCaseIOInfoDeserializer() {
            super(UseCaseIOInfo.class);
        }

        @Override
        public UseCaseIOInfo deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(UseCaseIOInfoImplementation.class);
        }
    }

    public static class UseCaseIOInfoModule extends SimpleModule{

        public UseCaseIOInfoModule(){
            addDeserializer(UseCaseIOInfo.class, new UseCaseIOInfoDeserializer());
        }
    }

    public static class UseCaseIOFieldInfoDeserializer extends StdDeserializer<UseCaseIOFieldInfo>{

        protected UseCaseIOFieldInfoDeserializer() {
            super(UseCaseIOFieldInfo.class);
        }

        @Override
        public UseCaseIOFieldInfo deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAs(UseCaseIOFieldInfoImplementation.class);
        }
    }

    public static class UseCaseIOFieldInfoModule extends SimpleModule{

        public UseCaseIOFieldInfoModule(){
            addDeserializer(UseCaseIOFieldInfo.class, new UseCaseIOFieldInfoDeserializer());
        }
    }
    
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SubscrInfo.proto

#define INTERNAL_SUPPRESS_PROTOBUF_FIELD_DEPRECATION
#include "SubscrInfo.pb.h"

#include <algorithm>

#include <google/protobuf/stubs/common.h>
#include <google/protobuf/stubs/port.h>
#include <google/protobuf/stubs/once.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/wire_format_lite_inl.h>
#include <google/protobuf/descriptor.h>
#include <google/protobuf/generated_message_reflection.h>
#include <google/protobuf/reflection_ops.h>
#include <google/protobuf/wire_format.h>
// @@protoc_insertion_point(includes)

namespace SAC {
class SubscrInfoDefaultTypeInternal : public ::google::protobuf::internal::ExplicitlyConstructed<SubscrInfo> {
} _SubscrInfo_default_instance_;

namespace protobuf_SubscrInfo_2eproto {


namespace {

::google::protobuf::Metadata file_level_metadata[1];

}  // namespace

PROTOBUF_CONSTEXPR_VAR ::google::protobuf::internal::ParseTableField
    const TableStruct::entries[] = {
  {0, 0, 0, ::google::protobuf::internal::kInvalidMask, 0, 0},
};

PROTOBUF_CONSTEXPR_VAR ::google::protobuf::internal::AuxillaryParseTableField
    const TableStruct::aux[] = {
  ::google::protobuf::internal::AuxillaryParseTableField(),
};
PROTOBUF_CONSTEXPR_VAR ::google::protobuf::internal::ParseTable const
    TableStruct::schema[] = {
  { NULL, NULL, 0, -1, -1, false },
};

const ::google::protobuf::uint32 TableStruct::offsets[] = {
  ~0u,  // no _has_bits_
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SubscrInfo, _internal_metadata_),
  ~0u,  // no _extensions_
  ~0u,  // no _oneof_case_
  ~0u,  // no _weak_field_map_
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SubscrInfo, planid_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SubscrInfo, activate_),
};

static const ::google::protobuf::internal::MigrationSchema schemas[] = {
  { 0, -1, sizeof(SubscrInfo)},
};

static ::google::protobuf::Message const * const file_default_instances[] = {
  reinterpret_cast<const ::google::protobuf::Message*>(&_SubscrInfo_default_instance_),
};

namespace {

void protobuf_AssignDescriptors() {
  AddDescriptors();
  ::google::protobuf::MessageFactory* factory = NULL;
  AssignDescriptors(
      "SubscrInfo.proto", schemas, file_default_instances, TableStruct::offsets, factory,
      file_level_metadata, NULL, NULL);
}

void protobuf_AssignDescriptorsOnce() {
  static GOOGLE_PROTOBUF_DECLARE_ONCE(once);
  ::google::protobuf::GoogleOnceInit(&once, &protobuf_AssignDescriptors);
}

void protobuf_RegisterTypes(const ::std::string&) GOOGLE_ATTRIBUTE_COLD;
void protobuf_RegisterTypes(const ::std::string&) {
  protobuf_AssignDescriptorsOnce();
  ::google::protobuf::internal::RegisterAllTypes(file_level_metadata, 1);
}

}  // namespace

void TableStruct::Shutdown() {
  _SubscrInfo_default_instance_.Shutdown();
  delete file_level_metadata[0].reflection;
}

void TableStruct::InitDefaultsImpl() {
  GOOGLE_PROTOBUF_VERIFY_VERSION;

  ::google::protobuf::internal::InitProtobufDefaults();
  _SubscrInfo_default_instance_.DefaultConstruct();
}

void InitDefaults() {
  static GOOGLE_PROTOBUF_DECLARE_ONCE(once);
  ::google::protobuf::GoogleOnceInit(&once, &TableStruct::InitDefaultsImpl);
}
void AddDescriptorsImpl() {
  InitDefaults();
  static const char descriptor[] = {
      "\n\020SubscrInfo.proto\022\003SAC\".\n\nSubscrInfo\022\016\n"
      "\006PlanID\030\001 \001(\005\022\020\n\010Activate\030\002 \001(\005b\006proto3"
  };
  ::google::protobuf::DescriptorPool::InternalAddGeneratedFile(
      descriptor, 79);
  ::google::protobuf::MessageFactory::InternalRegisterGeneratedFile(
    "SubscrInfo.proto", &protobuf_RegisterTypes);
  ::google::protobuf::internal::OnShutdown(&TableStruct::Shutdown);
}

void AddDescriptors() {
  static GOOGLE_PROTOBUF_DECLARE_ONCE(once);
  ::google::protobuf::GoogleOnceInit(&once, &AddDescriptorsImpl);
}
// Force AddDescriptors() to be called at static initialization time.
struct StaticDescriptorInitializer {
  StaticDescriptorInitializer() {
    AddDescriptors();
  }
} static_descriptor_initializer;

}  // namespace protobuf_SubscrInfo_2eproto


// ===================================================================

#if !defined(_MSC_VER) || _MSC_VER >= 1900
const int SubscrInfo::kPlanIDFieldNumber;
const int SubscrInfo::kActivateFieldNumber;
#endif  // !defined(_MSC_VER) || _MSC_VER >= 1900

SubscrInfo::SubscrInfo()
  : ::google::protobuf::Message(), _internal_metadata_(NULL) {
  if (GOOGLE_PREDICT_TRUE(this != internal_default_instance())) {
    protobuf_SubscrInfo_2eproto::InitDefaults();
  }
  SharedCtor();
  // @@protoc_insertion_point(constructor:SAC.SubscrInfo)
}
SubscrInfo::SubscrInfo(const SubscrInfo& from)
  : ::google::protobuf::Message(),
      _internal_metadata_(NULL),
      _cached_size_(0) {
  _internal_metadata_.MergeFrom(from._internal_metadata_);
  ::memcpy(&planid_, &from.planid_,
    reinterpret_cast<char*>(&activate_) -
    reinterpret_cast<char*>(&planid_) + sizeof(activate_));
  // @@protoc_insertion_point(copy_constructor:SAC.SubscrInfo)
}

void SubscrInfo::SharedCtor() {
  ::memset(&planid_, 0, reinterpret_cast<char*>(&activate_) -
    reinterpret_cast<char*>(&planid_) + sizeof(activate_));
  _cached_size_ = 0;
}

SubscrInfo::~SubscrInfo() {
  // @@protoc_insertion_point(destructor:SAC.SubscrInfo)
  SharedDtor();
}

void SubscrInfo::SharedDtor() {
}

void SubscrInfo::SetCachedSize(int size) const {
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
}
const ::google::protobuf::Descriptor* SubscrInfo::descriptor() {
  protobuf_SubscrInfo_2eproto::protobuf_AssignDescriptorsOnce();
  return protobuf_SubscrInfo_2eproto::file_level_metadata[kIndexInFileMessages].descriptor;
}

const SubscrInfo& SubscrInfo::default_instance() {
  protobuf_SubscrInfo_2eproto::InitDefaults();
  return *internal_default_instance();
}

SubscrInfo* SubscrInfo::New(::google::protobuf::Arena* arena) const {
  SubscrInfo* n = new SubscrInfo;
  if (arena != NULL) {
    arena->Own(n);
  }
  return n;
}

void SubscrInfo::Clear() {
// @@protoc_insertion_point(message_clear_start:SAC.SubscrInfo)
  ::memset(&planid_, 0, reinterpret_cast<char*>(&activate_) -
    reinterpret_cast<char*>(&planid_) + sizeof(activate_));
}

bool SubscrInfo::MergePartialFromCodedStream(
    ::google::protobuf::io::CodedInputStream* input) {
#define DO_(EXPRESSION) if (!GOOGLE_PREDICT_TRUE(EXPRESSION)) goto failure
  ::google::protobuf::uint32 tag;
  // @@protoc_insertion_point(parse_start:SAC.SubscrInfo)
  for (;;) {
    ::std::pair< ::google::protobuf::uint32, bool> p = input->ReadTagWithCutoffNoLastTag(127u);
    tag = p.first;
    if (!p.second) goto handle_unusual;
    switch (::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
      // int32 PlanID = 1;
      case 1: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(8u)) {

          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::int32, ::google::protobuf::internal::WireFormatLite::TYPE_INT32>(
                 input, &planid_)));
        } else {
          goto handle_unusual;
        }
        break;
      }

      // int32 Activate = 2;
      case 2: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(16u)) {

          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::int32, ::google::protobuf::internal::WireFormatLite::TYPE_INT32>(
                 input, &activate_)));
        } else {
          goto handle_unusual;
        }
        break;
      }

      default: {
      handle_unusual:
        if (tag == 0 ||
            ::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_END_GROUP) {
          goto success;
        }
        DO_(::google::protobuf::internal::WireFormatLite::SkipField(input, tag));
        break;
      }
    }
  }
success:
  // @@protoc_insertion_point(parse_success:SAC.SubscrInfo)
  return true;
failure:
  // @@protoc_insertion_point(parse_failure:SAC.SubscrInfo)
  return false;
#undef DO_
}

void SubscrInfo::SerializeWithCachedSizes(
    ::google::protobuf::io::CodedOutputStream* output) const {
  // @@protoc_insertion_point(serialize_start:SAC.SubscrInfo)
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  // int32 PlanID = 1;
  if (this->planid() != 0) {
    ::google::protobuf::internal::WireFormatLite::WriteInt32(1, this->planid(), output);
  }

  // int32 Activate = 2;
  if (this->activate() != 0) {
    ::google::protobuf::internal::WireFormatLite::WriteInt32(2, this->activate(), output);
  }

  // @@protoc_insertion_point(serialize_end:SAC.SubscrInfo)
}

::google::protobuf::uint8* SubscrInfo::InternalSerializeWithCachedSizesToArray(
    bool deterministic, ::google::protobuf::uint8* target) const {
  // @@protoc_insertion_point(serialize_to_array_start:SAC.SubscrInfo)
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  // int32 PlanID = 1;
  if (this->planid() != 0) {
    target = ::google::protobuf::internal::WireFormatLite::WriteInt32ToArray(1, this->planid(), target);
  }

  // int32 Activate = 2;
  if (this->activate() != 0) {
    target = ::google::protobuf::internal::WireFormatLite::WriteInt32ToArray(2, this->activate(), target);
  }

  // @@protoc_insertion_point(serialize_to_array_end:SAC.SubscrInfo)
  return target;
}

size_t SubscrInfo::ByteSizeLong() const {
// @@protoc_insertion_point(message_byte_size_start:SAC.SubscrInfo)
  size_t total_size = 0;

  // int32 PlanID = 1;
  if (this->planid() != 0) {
    total_size += 1 +
      ::google::protobuf::internal::WireFormatLite::Int32Size(
        this->planid());
  }

  // int32 Activate = 2;
  if (this->activate() != 0) {
    total_size += 1 +
      ::google::protobuf::internal::WireFormatLite::Int32Size(
        this->activate());
  }

  int cached_size = ::google::protobuf::internal::ToCachedSize(total_size);
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = cached_size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
  return total_size;
}

void SubscrInfo::MergeFrom(const ::google::protobuf::Message& from) {
// @@protoc_insertion_point(generalized_merge_from_start:SAC.SubscrInfo)
  GOOGLE_DCHECK_NE(&from, this);
  const SubscrInfo* source =
      ::google::protobuf::internal::DynamicCastToGenerated<const SubscrInfo>(
          &from);
  if (source == NULL) {
  // @@protoc_insertion_point(generalized_merge_from_cast_fail:SAC.SubscrInfo)
    ::google::protobuf::internal::ReflectionOps::Merge(from, this);
  } else {
  // @@protoc_insertion_point(generalized_merge_from_cast_success:SAC.SubscrInfo)
    MergeFrom(*source);
  }
}

void SubscrInfo::MergeFrom(const SubscrInfo& from) {
// @@protoc_insertion_point(class_specific_merge_from_start:SAC.SubscrInfo)
  GOOGLE_DCHECK_NE(&from, this);
  _internal_metadata_.MergeFrom(from._internal_metadata_);
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  if (from.planid() != 0) {
    set_planid(from.planid());
  }
  if (from.activate() != 0) {
    set_activate(from.activate());
  }
}

void SubscrInfo::CopyFrom(const ::google::protobuf::Message& from) {
// @@protoc_insertion_point(generalized_copy_from_start:SAC.SubscrInfo)
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

void SubscrInfo::CopyFrom(const SubscrInfo& from) {
// @@protoc_insertion_point(class_specific_copy_from_start:SAC.SubscrInfo)
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

bool SubscrInfo::IsInitialized() const {
  return true;
}

void SubscrInfo::Swap(SubscrInfo* other) {
  if (other == this) return;
  InternalSwap(other);
}
void SubscrInfo::InternalSwap(SubscrInfo* other) {
  std::swap(planid_, other->planid_);
  std::swap(activate_, other->activate_);
  std::swap(_cached_size_, other->_cached_size_);
}

::google::protobuf::Metadata SubscrInfo::GetMetadata() const {
  protobuf_SubscrInfo_2eproto::protobuf_AssignDescriptorsOnce();
  return protobuf_SubscrInfo_2eproto::file_level_metadata[kIndexInFileMessages];
}

#if PROTOBUF_INLINE_NOT_IN_HEADERS
// SubscrInfo

// int32 PlanID = 1;
void SubscrInfo::clear_planid() {
  planid_ = 0;
}
::google::protobuf::int32 SubscrInfo::planid() const {
  // @@protoc_insertion_point(field_get:SAC.SubscrInfo.PlanID)
  return planid_;
}
void SubscrInfo::set_planid(::google::protobuf::int32 value) {
  
  planid_ = value;
  // @@protoc_insertion_point(field_set:SAC.SubscrInfo.PlanID)
}

// int32 Activate = 2;
void SubscrInfo::clear_activate() {
  activate_ = 0;
}
::google::protobuf::int32 SubscrInfo::activate() const {
  // @@protoc_insertion_point(field_get:SAC.SubscrInfo.Activate)
  return activate_;
}
void SubscrInfo::set_activate(::google::protobuf::int32 value) {
  
  activate_ = value;
  // @@protoc_insertion_point(field_set:SAC.SubscrInfo.Activate)
}

#endif  // PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)

}  // namespace SAC

// @@protoc_insertion_point(global_scope)
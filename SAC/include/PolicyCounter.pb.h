// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PolicyCounter.proto

#ifndef PROTOBUF_PolicyCounter_2eproto__INCLUDED
#define PROTOBUF_PolicyCounter_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3003000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3003000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_table_driven.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/unknown_field_set.h>
// @@protoc_insertion_point(includes)
namespace SAC {
class PolicyCounter;
class PolicyCounterDefaultTypeInternal;
extern PolicyCounterDefaultTypeInternal _PolicyCounter_default_instance_;
}  // namespace SAC

namespace SAC {

namespace protobuf_PolicyCounter_2eproto {
// Internal implementation detail -- do not call these.
struct TableStruct {
  static const ::google::protobuf::internal::ParseTableField entries[];
  static const ::google::protobuf::internal::AuxillaryParseTableField aux[];
  static const ::google::protobuf::internal::ParseTable schema[];
  static const ::google::protobuf::uint32 offsets[];
  static void InitDefaultsImpl();
  static void Shutdown();
};
void AddDescriptors();
void InitDefaults();
}  // namespace protobuf_PolicyCounter_2eproto

// ===================================================================

class PolicyCounter : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:SAC.PolicyCounter) */ {
 public:
  PolicyCounter();
  virtual ~PolicyCounter();

  PolicyCounter(const PolicyCounter& from);

  inline PolicyCounter& operator=(const PolicyCounter& from) {
    CopyFrom(from);
    return *this;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const PolicyCounter& default_instance();

  static inline const PolicyCounter* internal_default_instance() {
    return reinterpret_cast<const PolicyCounter*>(
               &_PolicyCounter_default_instance_);
  }
  static PROTOBUF_CONSTEXPR int const kIndexInFileMessages =
    0;

  void Swap(PolicyCounter* other);

  // implements Message ----------------------------------------------

  inline PolicyCounter* New() const PROTOBUF_FINAL { return New(NULL); }

  PolicyCounter* New(::google::protobuf::Arena* arena) const PROTOBUF_FINAL;
  void CopyFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void MergeFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void CopyFrom(const PolicyCounter& from);
  void MergeFrom(const PolicyCounter& from);
  void Clear() PROTOBUF_FINAL;
  bool IsInitialized() const PROTOBUF_FINAL;

  size_t ByteSizeLong() const PROTOBUF_FINAL;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input) PROTOBUF_FINAL;
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const PROTOBUF_FINAL;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* target) const PROTOBUF_FINAL;
  int GetCachedSize() const PROTOBUF_FINAL { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const PROTOBUF_FINAL;
  void InternalSwap(PolicyCounter* other);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return NULL;
  }
  inline void* MaybeArenaPtr() const {
    return NULL;
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const PROTOBUF_FINAL;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // int32 PID = 1;
  void clear_pid();
  static const int kPIDFieldNumber = 1;
  ::google::protobuf::int32 pid() const;
  void set_pid(::google::protobuf::int32 value);

  // int32 PCS = 2;
  void clear_pcs();
  static const int kPCSFieldNumber = 2;
  ::google::protobuf::int32 pcs() const;
  void set_pcs(::google::protobuf::int32 value);

  // @@protoc_insertion_point(class_scope:SAC.PolicyCounter)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::int32 pid_;
  ::google::protobuf::int32 pcs_;
  mutable int _cached_size_;
  friend struct protobuf_PolicyCounter_2eproto::TableStruct;
};
// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
// PolicyCounter

// int32 PID = 1;
inline void PolicyCounter::clear_pid() {
  pid_ = 0;
}
inline ::google::protobuf::int32 PolicyCounter::pid() const {
  // @@protoc_insertion_point(field_get:SAC.PolicyCounter.PID)
  return pid_;
}
inline void PolicyCounter::set_pid(::google::protobuf::int32 value) {
  
  pid_ = value;
  // @@protoc_insertion_point(field_set:SAC.PolicyCounter.PID)
}

// int32 PCS = 2;
inline void PolicyCounter::clear_pcs() {
  pcs_ = 0;
}
inline ::google::protobuf::int32 PolicyCounter::pcs() const {
  // @@protoc_insertion_point(field_get:SAC.PolicyCounter.PCS)
  return pcs_;
}
inline void PolicyCounter::set_pcs(::google::protobuf::int32 value) {
  
  pcs_ = value;
  // @@protoc_insertion_point(field_set:SAC.PolicyCounter.PCS)
}

#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)


}  // namespace SAC

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_PolicyCounter_2eproto__INCLUDED